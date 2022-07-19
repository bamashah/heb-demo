package com.boot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // This tells Hibernate to make a table out of this class
public class Item {
    @Id
    private Long id;
    
    private String description;
    
    @Temporal(TemporalType.DATE)
	private Date lastSold;

	private Integer shelfLife;
    private String department;
    private Double price;
    private String unit;
    private Integer xFor;
    private Double cost;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getLastSold() {
		return lastSold;
	}
	
	public void setLastSold(Date lastSold) {
		this.lastSold = lastSold;
	}
	
	public Integer getShelfLife() {
		return shelfLife;
	}
	
	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Integer getxFor() {
		return xFor;
	}
	
	public void setxFor(Integer xFor) {
		this.xFor = xFor;
	}
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}

}