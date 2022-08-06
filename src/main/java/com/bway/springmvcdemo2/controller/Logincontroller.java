package com.bway.springmvcdemo2.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springmvcdemo2.model.User;
import com.bway.springmvcdemo2.repository.UserRepository;
import com.bway.springmvcdemo2.utils.VerifyRecaptcha;

@Controller
public class Logincontroller {
	
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/login")
	public String showLogin() {
		
		return"loginForm";
	}
	
	
	@PostMapping("/login")
	public String dologin(@ModelAttribute User user,Model model,@RequestParam("g-recaptcha-response") String reCode) throws IOException {
		
		if(	VerifyRecaptcha.verify(reCode)) {
			
		
		
	User usr=userRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		if(usr!=null) {
			model.addAttribute("uname",user.getUsername());
			
		return "home";
	}else {
		model.addAttribute("message","user not found!!");
		return "loginForm";
		
	}
		}
		model.addAttribute("message","Are you a robert!!");
		return "loginForm";
	}

}
