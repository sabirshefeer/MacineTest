package com.project.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String homePage() {
		System.out.println("'/home' Request Recieved");
		
		return "Register";
	}
}
