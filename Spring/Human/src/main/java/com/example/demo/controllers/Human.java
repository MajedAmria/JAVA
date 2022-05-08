package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Human {
	   @RequestMapping("/")
	    public String hello() {
	        return "Hello Human";
	    }
//	    @RequestMapping("/name")
//	    public String name(@RequestParam(value="firstname") String firstname,
//	    					@RequestParam(value="lastname") String lastname) {
//	        return "Hello " + firstname +" "+lastname;
//	    }
	    @RequestMapping("/name")
	    public String manytime(@RequestParam(value="firstname") String firstname,
	    		              @RequestParam(value="time") int time) {
	    String name="Hello "+firstname+"||";
			return name.repeat(time);
	    	
	
	    	
		
	    }
}
