package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@RefreshScope   //to reflect ConfigServer changes 
public class EmployeeOperationsController {

	@Value("${dbuser}")
	private String user;
	
	@Value("${dbpwd}")
	private String pwd;
	
	@GetMapping("/show")
	public String showData() {
		return "Data collected through external Config Server : "+user+"---"+pwd;
	}
}
