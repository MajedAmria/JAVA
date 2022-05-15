package com.example.demo.controllers;

import java.util.List;



import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import com.example.demo.model.Language;
import com.example.demo.servecs.Service;

@org.springframework.stereotype.Controller
public class Controller {
	
	private final Service service;

	public Controller(Service service) {
		this.service = service;
	}
	

	@GetMapping("/")
	 public String index(Model model,@ModelAttribute("lang") Language language) {
			List<Language> lan=service.allLanguage() ;
			model.addAttribute("language",lan);
		 return "index.jsp";
	 }
	

	@PostMapping("/lan")
	public String create(@Valid @ModelAttribute("lang") Language language,BindingResult result) 
	{
		 if (result.hasErrors()) {
	            return "index.jsp";
		 }
		 else {
		service.addLanguage(language);
	    return "redirect:/";
	}
}
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
		Language language = service.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
	 @PutMapping("/edit/{id}")
	    public String update(@Valid @ModelAttribute("lang") Language language , BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	service.updateLanguage(language);
	            return "redirect:/";
	        }
	    }
	 
	 @GetMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 service.deleteLanguage(id);
	        return "redirect:/";
	    }
	
	
@GetMapping("/language/{id}")
public String Language(@PathVariable("id") Long id, Model model) {
	Language Lan = service.findLanguage(id);
    model.addAttribute("language", Lan);
    return "Language.jsp";
}

}
