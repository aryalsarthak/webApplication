package com.bway.springmvcdemo2.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	@GetMapping("/gallary")
	public String gallery(Model model) {
			File dir=new File("src/main/resources/static/images");
			String [] imgnames=dir.list();
			model.addAttribute("imglist", imgnames);
		
		return"gallery";
	}

}
