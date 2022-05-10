package com.example.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Omikuji {

	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	@RequestMapping(value="/omikuji", method=RequestMethod.POST)
	public String omikuji(HttpSession session,
			@RequestParam(value="number") int number,
		    @RequestParam(value="name") String name,
		    @RequestParam(value="person") String person,
		    @RequestParam(value="hoppy") String hoppy,
		    @RequestParam(value="living") String living,
		    @RequestParam(value="des") String des) {
		session.setAttribute("number", number);
		session.setAttribute("name", name);
		session.setAttribute("person", person);
		session.setAttribute("hoppy", hoppy);
		session.setAttribute("living", living);
		session.setAttribute("des", des);
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String show(HttpSession session) {
		session.getAttribute("number");
		session.getAttribute("name");
		session.getAttribute("person");
		session.getAttribute("hoppy");
		session.getAttribute("living");
		session.getAttribute("des");
		return "show.jsp";
	}
}
