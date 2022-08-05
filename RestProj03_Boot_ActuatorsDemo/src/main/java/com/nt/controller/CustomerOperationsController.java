package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cust")
public class CustomerOperationsController {
	
	@GetMapping("/display")
	public String displayData() {
		return "Customer info will be displayed here.....Welcome to Call Center.";
	}
}
