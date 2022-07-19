package com.boot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Item;

@Service
public class FilterService {

    @PersistenceContext
    private EntityManager entityManager;
    
	@Autowired
    private UtilService utilService;
    
    public List<Item> getResults(
    		Long id, 
    		String description, 
    		String lastSold,
    		Integer shelfLife,
    		String department,
    		Double price,
    		Double cost) {
	    CriteriaBuilder qb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Item> cq = qb.createQuery(Item.class);
	    Root<Item> user = cq.from(Item.class);

	    //Constructing list of parameters
	    List<Predicate> predicates = new ArrayList<Predicate>();

	    //Adding predicates in case of parameter not being null
	    if (id != null) {
	        predicates.add(qb.equal(user.get("id"), id));
	    }
	    
	    if (!StringUtils.isEmpty(description)) { 
	        predicates.add(qb.like(user.<String>get("description"), "%"+description+"%"));
	    }
	    
	    if (!StringUtils.isEmpty(lastSold)) { 
	    	Date lastSoldDate = utilService.getDateFromString(lastSold);
	        predicates.add(qb.equal(user.get("lastSold"), lastSoldDate));
	    }

	    if (shelfLife != null) {
	        predicates.add(qb.equal(user.get("shelfLife"), shelfLife));
	    }
	    
	    if (!StringUtils.isEmpty(department)) { 
	        predicates.add(qb.like(user.<String>get("department"), "%"+department+"%"));
	    }
	    
	    if (price != null) {
	        predicates.add(qb.equal(user.get("price"), price));
	    }	   
	    
	    if (cost != null) {
	        predicates.add(qb.equal(user.get("cost"), cost));
	    }	    
	    
	    //query itself
	    cq.select(user).where(predicates.toArray(new Predicate[]{}));
	    
	    //execute query and do something with result

	    return entityManager.createQuery(cq).getResultList();
    }

}