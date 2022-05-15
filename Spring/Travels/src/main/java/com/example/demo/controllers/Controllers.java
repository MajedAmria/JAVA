package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.models.Expense;
import com.example.demo.services.Service;
import java.util.*;

import javax.validation.Valid;
@Controller
public class Controllers {
	private final Service conservice;
	
	public Controllers(Service service) {
		this.conservice = service;
		}
	
	@RequestMapping("/")
 public String index(Model model,@ModelAttribute("expense") Expense expenses) {
		List<Expense> exp=conservice.allexpense() ;
		model.addAttribute("exp",exp);
	 return "index.jsp";
 }
	@PostMapping("/exp")
	public String create(@Valid @ModelAttribute("expense") Expense expenses,BindingResult result) 
	{
		 if (result.hasErrors()) {
	            return "index.jsp";
		 }
		 else {
		conservice.addexpense(expenses);
	    return "redirect:/";
	}
}
	@GetMapping("/edit/{id}/update")
    public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = conservice.findexpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }
	 @PutMapping("/edit/{id}")
	    public String update(@Valid @ModelAttribute("expense") Expense expense , BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	conservice.updateexpense(expense);
	            return "redirect:/";
	        }
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 conservice.deleteBook(id);
	        return "redirect:/";
	    }
	
	
@GetMapping("/expense/{id}")
public String expense(@PathVariable("id") Long id, Model model) {
	Expense expense = conservice.findexpense(id);
    model.addAttribute("expense", expense);
    return "expense.jsp";
}
}