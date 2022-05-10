package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Gold {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold")==null) {
		 session.setAttribute("gold", 0);
		 session.setAttribute("activities", new ArrayList<String>());
		}
		else {
			session.getAttribute("gold");
			session.getAttribute("activities");
		}
		 
		return "index.jsp";
	}
	
	@RequestMapping(value="/process_money",method=RequestMethod.POST)
	public String process_money(HttpSession session,
			@RequestParam(value="which_form") String building ) {
		
		if("farm".equals(building)) {
			Random r = new Random();
			int num = r.nextInt(20 + 1 - 10) + 10;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, "Earned " + num + " gold from the farm! \n" );
			session.setAttribute("activities", activities);
		}
		
		else if("cave".equals(building)) {
			Random r = new Random();
			int num = r.nextInt(20 + 1 - 10) + 10;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, "Earned " + num + " gold from the cave! \n" );
			session.setAttribute("activities", activities);
		}
		
		else if("house".equals(building)) {
			Random r = new Random();
			int num = r.nextInt(20 + 1 - 10) + 10;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, "Earned " + num + " gold from the house! \n" );
			session.setAttribute("activities", activities);
		}
		
		else if("quest".equals(building)) {
			Random r = new Random();
			int num = r.nextInt(50 + 1 +50) -50;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + num);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, "Earned or takes " + num + " gold from the quest! \n" );
			session.setAttribute("activities", activities);
		}
					return "redirect:/";
	}

}
	

