package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.DashboardDTO;
import com.example.demo.service.UserService;

import org.springframework.ui.Model;
 


@Controller
public class PageController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users-page")
	public String usersPage() {
		
		return "users";
	}
	
	@GetMapping("/back")
		public String formPage() {
			return "form";
		}
	
    @GetMapping("/reports")
    public String reportsPage() {
    	return "reports";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
    	DashboardDTO dashboardData=userService.getDashboardData();
    	model.addAttribute("dashboard", dashboardData);
    	
    	return "dashboard";
    }
	
    
	}
	

