package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class Test {
	
	@RequestMapping("/")
	public String welcome() {
		
		return "Welcome";
	}
	
	@RequestMapping("/search")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model,
	    @RequestParam(value="email") String email,
	    @RequestParam(value="password") String password) {
		model.addAttribute("email", email);
	    // CODE TO PROCESS FORM ie. check email and password
	    return "redirect:/search";
	}
 
}
