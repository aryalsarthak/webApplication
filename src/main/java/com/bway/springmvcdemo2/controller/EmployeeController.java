package com.bway.springmvcdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springmvcdemo2.model.Employee;
import com.bway.springmvcdemo2.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepo;
	  
	@GetMapping("/employee")
	public String showEmployeeForm() {
		
		return"Employeeform";
	}
	
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute Employee emp) {
		
		employeeRepo.save(emp);
		return"Employeeform";
	}
	
	   @GetMapping("/list")
	   public String getAllEmp(Model model) {
	
		   model.addAttribute("empList",employeeRepo.findAll());
		   
		   return"ListEmployee";
	   }
	   @GetMapping("/delete")
	   public String deleteEmp(@RequestParam Long id) {
		   
		   employeeRepo.deleteById(id);
		   return"redirect:list";
	   }
	    @GetMapping("/edit")
	   public String editEmp(@RequestParam Long id,Model model) {
		   
	    	model.addAttribute("emodel",employeeRepo.getById(id));
		   return"editForm";
	   }
	    @PostMapping("/update")
	    public String updateEmp(@ModelAttribute Employee emp) {
	    	
	    	employeeRepo.save(emp);
	    	
	    	return"redirect:list";
	    }
	}
