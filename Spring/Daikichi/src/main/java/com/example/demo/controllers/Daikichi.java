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
            return "Today you will find luck in all your endeavors!";
    }
	@RequestMapping("/tommorw")
    public String tommorw() {
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
}
