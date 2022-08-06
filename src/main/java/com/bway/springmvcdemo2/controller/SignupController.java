package com.bway.springmvcdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springmvcdemo2.model.User;
import com.bway.springmvcdemo2.repository.UserRepository;

@Controller
public class SignupController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	
	
	
	@GetMapping("/signup")
	public String getSignup() {
		return"signup";
	}
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		userRepo.save(user);
		
		return"loginForm";
	}

}
