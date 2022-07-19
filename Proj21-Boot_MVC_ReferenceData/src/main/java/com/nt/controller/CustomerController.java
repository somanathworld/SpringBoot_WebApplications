package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerMgmtService service;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showCustomerFormPage(@ModelAttribute("cust")Customer cust) {
		System.out.println("CustomerController.showCustomerFormPage()");
		return "customer_register";
	}
	
	@PostMapping("/states")
	public String showStatesByCountry(@RequestParam("country") String country,
										@ModelAttribute("cust") Customer cust,
										Map<String, Object> map) {
		System.out.println("CustomerController.showStatesByCountry()");
		List<String> stateList = service.getStatesByCountry(country);
		map.put("statesInfo", stateList);
		return "customer_register";
	}
	
	@PostMapping("/customer_register")
	public String registerCustomer(@ModelAttribute("cust1")Customer cust) {
		return "show_result";
	}
	
	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries(){
		return service.getAllCountries();
	}
	
	@ModelAttribute("languagesInfo")
	public Set<String> populateLanguages(){
		return service.getAllLanguages();
	}
	
	@ModelAttribute("hobbiesInfo")
	public Set<String> populateHobbies(){
		return service.getAllHobbies();
	}

	
}
