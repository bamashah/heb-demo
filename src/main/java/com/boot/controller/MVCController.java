package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.model.Item;
import com.boot.service.FilterService;

@Controller
public class MVCController {
	
	@Autowired
    private FilterService filterService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search() {
		return new ModelAndView("search", "command", new Item());
	}
    
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(Model  model, 
				@RequestParam(value="id", required = false) Long id,
				@RequestParam(value="description", required = false) String description,	
				@RequestParam(value="lastSold", required = false) String lastSold,	
				@RequestParam(value="shelfLife", required = false) Integer shelfLife,				
				@RequestParam(value="department", required = false) String department,	
				@RequestParam(value="price", required = false) Double price,				
				@RequestParam(value="cost", required = false) Double cost) {    	

//        System.out.println("value " + id + " " + id.getClass());
//        System.out.println("price " + description + " " + description.getClass());
        
        
        List<Item> items = filterService.getResults(id, description, lastSold, shelfLife, department, price, cost);
        model.addAttribute("items", items);
        
        return "result";
    }
}