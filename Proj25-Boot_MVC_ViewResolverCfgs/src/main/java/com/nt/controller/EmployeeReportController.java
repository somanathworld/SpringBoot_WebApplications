package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeReportController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("EmployeeReportController.showHomePage()");
		return "emp_report_home_page";
	}
	
	@GetMapping("/report")
	public String generateReport(@RequestParam("type")String type, Map<String, Object> map) {
		System.out.println("EmployeeReportController.generateReport()");
		Iterable<Employee> empList = service.getAllEmployees();
		map.put("empList", empList);
		if(type.equalsIgnoreCase("pdf")) {
			return "pdfreport";
		}else {
			return "excelreport";
		}
	}
}
