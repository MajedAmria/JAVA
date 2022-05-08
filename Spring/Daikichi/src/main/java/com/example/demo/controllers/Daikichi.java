package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Daikichi")
public class Daikichi {
	@RequestMapping("")
    public String daikichi() {
            return "Welcome";
    }
	@RequestMapping("/today")
    public String today() {
            return "today";
    }
	@RequestMapping("/tommorw")
    public String tommorw() {
            return "tommorw";
    }
}
