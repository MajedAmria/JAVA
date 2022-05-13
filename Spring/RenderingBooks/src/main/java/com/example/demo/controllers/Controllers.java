package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;

@Controller
public class Controllers {
	
	BookService bookservice;
	
	@RequestMapping("/books/{id}")
	public String index(Model model,@PathVariable("id") Long id) {
		Book book=bookservice.findBook(id);
		System.out.println(id);
		model.addAttribute("book", book);
		return "index.jsp";
	}

}
