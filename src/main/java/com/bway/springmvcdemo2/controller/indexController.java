package com.bway.springmvcdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@GetMapping("/")
	public String indexpage() {
		
		return"loginForm";
	}

}
