package com.example.demo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Dojo;
import com.example.demo.model.Ninja;
import com.example.demo.service.DojoService;
import com.example.demo.service.NinjaService;

@Controller
public class Controllers {

	private final DojoService dojoservice;
	private final NinjaService ninjaservice;
	
	public Controllers(DojoService dojoservice,NinjaService ninjaservice) {
		this.dojoservice = dojoservice;
		this.ninjaservice=ninjaservice;

	}
	
	@GetMapping("/")
	 public String index(Model model,@ModelAttribute("dojo") Dojo dojo) {
			List<Dojo> dojos=dojoservice.alldojos();
			List<Ninja>ninjas=ninjaservice.allninjas();
			model.addAttribute("Ninja",ninjas);
			model.addAttribute("Dojo",dojos);
		 return "show.jsp";
	 }
	
	@GetMapping("/dojo/new")
	 public String dojo(@ModelAttribute("dojo") Dojo dojo) {

		 return "newdojo.jsp";
		 
	 }
	@PostMapping("/dojo")
	public String createdojo(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result) {
		 if (result.hasErrors()) {
	            return "newdojo.jsp";
	        } else {
		dojoservice.adddojo(dojo);
	    return "redirect:/";
	        }
	}
	
	@GetMapping("/ninja/new")
	 public String ninja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos=dojoservice.alldojos();
		model.addAttribute("Dojo",dojos);
		 return "newninja.jsp";
		 
	 }
	@PostMapping("/ninja")
	public String createninja(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result) {
		 if (result.hasErrors()) {
	            return "newninja.jsp";
	        } else {
		ninjaservice.addninja(ninja);
		
	    return "redirect:/";
	}
		 }
	
}
