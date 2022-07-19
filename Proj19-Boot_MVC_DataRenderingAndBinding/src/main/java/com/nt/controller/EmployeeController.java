package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.mode.Employee;

@Controller
public class EmployeeController {

	public EmployeeController() {
		System.out.println("EmployeeController.EmployeeController()");
	}
	
	@GetMapping("/")
	public String showHome() {
		System.out.println("EmployeeController.showHome()");
		return "home";
	}
	
	@GetMapping("/register")
	public String showForm() {
		System.out.println("EmployeeController.showForm()");
		return "emp_registration_form";
	}
	
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee emp) {
		System.out.println("EmployeeController.registerEmployee()");
		System.out.println(emp);
		return "result";
	}
}
