package com.example.demo.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Counter {
	@RequestMapping("/")
    public String index(HttpSession session) {
        
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			}
			else {
				session.setAttribute("count", ((Integer) session.getAttribute("count")) + 1);
			}
		session.setAttribute("count", 0);
        return "index.jsp";
    }
	
	@RequestMapping("/counter")
    public String counter() {
        
        return "counter.jsp";
    }
	

	
	
}
