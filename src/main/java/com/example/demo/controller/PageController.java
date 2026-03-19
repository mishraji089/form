package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

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
	
	}
	

