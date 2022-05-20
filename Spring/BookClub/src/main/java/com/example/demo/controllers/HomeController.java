package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.models.User;
import com.example.demo.serviecs.UserService;


@Controller
public class HomeController {
    
    // Add once service is implemented:
     @Autowired
     private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new User());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    
        User registerUser=userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new User());
            return "index.jsp";
        }
     
        session.setAttribute("userId", registerUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") User newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
  
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String home(Model model,HttpSession session) {
    	if(session.getAttribute("userId")!=null) {
    		Long userId=(Long)session.getAttribute("userId");
    		User currenUser=userServ.findbyId(userId);
    		model.addAttribute("currentUser", currenUser);
    		return "home.jsp";
    	}

    	return "redirect:/";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}