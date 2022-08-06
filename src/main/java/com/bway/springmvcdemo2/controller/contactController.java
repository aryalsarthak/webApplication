package com.bway.springmvcdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class contactController {
	  
	@GetMapping("/contact")
	public String getForm() {
		return"emailForm";
	}
}
