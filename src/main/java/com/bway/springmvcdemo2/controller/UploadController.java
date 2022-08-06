package com.bway.springmvcdemo2.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
	public String upload() {
		
		return"upload";
	}
	
	
	@PostMapping("/upload")
	public String saveImage(@RequestParam("file") MultipartFile file,Model model) throws IOException {
		if(!file.isEmpty()) {
			
			FileOutputStream fout;
			
				fout = new FileOutputStream("src/main/resources/static/images"+file.getOriginalFilename());
			
			
			
			fout.write(file.getBytes());
			
			fout.close();
			model.addAttribute("message","upload successful");
			return "upload";
		}
		model.addAttribute("message","upload failed");
		
		return"upload";
	}

}

	
