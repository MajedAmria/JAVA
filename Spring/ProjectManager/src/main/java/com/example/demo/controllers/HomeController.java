package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.LoginUser;
import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.example.demo.services.ProjectService;
import com.example.demo.services.UserService;

@Controller
public class HomeController {
    
    // Add once service is implemented:
    
     private UserService userServ;
     private ProjectService proserv;
     
    
    public HomeController(UserService userServ, ProjectService proserv) {
		this.userServ = userServ;
		this.proserv = proserv;
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
    		List<Project> containProjects=proserv.contain(currenUser);
    		List<Project> notContainProjects=proserv.notContain(currenUser);
    		model.addAttribute("notcontain", notContainProjects);
    		model.addAttribute("contain", containProjects);
    		model.addAttribute("currentUser", currenUser);
    		return "home.jsp";
    	}

    	return "redirect:/";
    }
    
    @GetMapping("/new")
    public String create(@ModelAttribute("project")Project progect) {
    	
    	return "newproject.jsp";
    }
    @PostMapping("/new")
    public String createproject(@Valid@ModelAttribute("project")Project project,BindingResult result,HttpSession session) {
	    if (result.hasErrors()) {
	            return "newproject.jsp";
		 }
		 else {
			 Long userId=(Long)session.getAttribute("userId");
			 User currenUser=userServ.findbyId(userId);
			 project.setProjectLeader(currenUser);
			 proserv.creatproject(project);
		 }
    	return "redirect:/home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}