package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.model.Baby;
import com.example.demo.model.LoginUser;
import com.example.demo.model.User;
import com.example.demo.services.BabyService;
import com.example.demo.services.UserService;

@Controller
public class HomeController {
    
    // Add once service is implemented:
     
     private UserService userServ;
     private BabyService babyServ;
     
    
    public HomeController(UserService userServ, BabyService babyServ) {
		this.userServ = userServ;
		this.babyServ = babyServ;
	}

	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    
        User registerUser=userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
     
        session.setAttribute("userId", registerUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
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
    		List<Baby> babies=babyServ.allBabies();
			model.addAttribute("babies",babies);
    		return "home.jsp";
    	}

    	return "redirect:/";
    }
    
    
    @GetMapping("/new")
	 public String newbabyname(Model model,@ModelAttribute("baby") Baby baby) {
		
		 return "newName.jsp";
	 }
	

	@PostMapping("/new")
	public String createnewbabyname(@Valid @ModelAttribute("baby") Baby baby,BindingResult result,HttpSession session) 
	{
		 if (result.hasErrors()) {
	            return "newName.jsp";
		 }
		 else {
		Long userId=(Long)session.getAttribute("userId");
	    User currenUser=userServ.findbyId(userId);
	    baby.setUser(currenUser);
		babyServ.create(baby);
		 return "redirect:/home";
		 }
	   
	}
	@PostMapping("/upvvote")
	public String vote(Model model) {
		
		 return "redirect:/home";
		
	   
	}
    
	@GetMapping("/show/{id}")
	 public String show(Model model,@PathVariable("id") Long id,@ModelAttribute("baby") Baby baby,HttpSession session) {
		Long userId=(Long)session.getAttribute("userId");
	    User currenUser=userServ.findbyId(userId);
	    model.addAttribute("curruser",currenUser);
		Baby currBaby=babyServ.findbyId(id);
		model.addAttribute("currbaby",currBaby);
		 return "show.jsp";
	 }
	
	@GetMapping("/edit/{id}/update")
    public String edit(@PathVariable("id") Long id, Model model) {
		Baby baby = babyServ.findbyId(id);
        model.addAttribute("baby", baby);
        return "edit.jsp";
    }
	 @PutMapping("/edit/{id}")
	    public String update(@Valid @ModelAttribute("baby") Baby baby , BindingResult result,HttpSession session) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	Long userId=(Long)session.getAttribute("userId");
	    		User currenUser=userServ.findbyId(userId);
	    		baby.setUser(currenUser);
	        	babyServ.updateBabyName(baby);
	            return "redirect:/home";
	        }
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 babyServ.deleteBaby(id);
	        return "redirect:/home";
	    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}