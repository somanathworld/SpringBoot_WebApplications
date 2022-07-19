package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerController {

	@GetMapping("/")
	public String showHomePage() {
		System.out.println("CustomerController.showHomePage()");
		return "home";
	}
	
	@GetMapping("/customer_register")
	public String showCustomerFormPage(@ModelAttribute("cust")Customer cust) {
		System.out.println("CustomerController.showCustomerFormPage()");
		return "customer_registration";
	}
	@PostMapping("/customer_register")
	public String processCustomerFormPage(@ModelAttribute("cust")Customer cust) {
		System.out.println("CustomerController.showCustomerFormPage()"+cust);
		return "customer_registration";
	}
}
