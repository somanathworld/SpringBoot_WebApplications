package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("EmployeeController.showHomePage()");
		return "home";
	}
	
	
	@GetMapping("/find_emp")
	public String getEemployeeByEno(@RequestParam("eno")Integer eno, Map<String, Object> map) throws EmployeeNotFoundException {
		map.put("empInfo",service.fetchEmployeeByEno(eno));
		return "result";
	}
	
}
