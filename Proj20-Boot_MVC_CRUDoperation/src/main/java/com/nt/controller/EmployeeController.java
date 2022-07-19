package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService service;
	
	public EmployeeController() {
		System.out.println("EmployeeController.EmployeeController()");
	}
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("EmployeeController.showHomePage()");
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String, Object> map) {
		System.out.println("EmployeeController.showEmployeeReport()");
		//user service
		Iterable<Employee> empList = service.getAllEmployees();
		map.put("empInfo", empList);
		return "employee_report";
	}
	
	@GetMapping("/insert_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.showAddEmployeeForm()");
		return "add_employee";
	}
/*	
 	//This methdo havind double posting problem
	@PostMapping("/insert_employee")
	public String registerEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.registerEmployee()");
		//use service
		String result = service.insertEmployee(emp);
		Iterable<Employee> empList = service.getAllEmployees();
		map.put("resultMsg", result);
		map.put("empInfo", empList);
		
		return "employee_report";
	}
*/	
	@PostMapping("/insert_employee")
	public String registerEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.registerEmployee()");
		//use service
		String result = service.insertEmployee(emp);
		attrs.addFlashAttribute("resultMsg", result);
		
		return "redirect:emp_report";
	}

	
	@GetMapping("/edit_employee")
	public String showEditEmployeeForm(@RequestParam Integer eno, @ModelAttribute("emp")Employee emp) {
		//use service
		Employee srcEmp = service.getEmployeeByEno(eno);
		BeanUtils.copyProperties(srcEmp, emp);
		return "modify_employee";
	}
	
/*
 	//This methdo havind double posting problem
	@PostMapping("/edit_employee")
	public String editEmployee(Map<String, Object> map, @ModelAttribute("emp")Employee emp) {
		//use service
		String result = service.updateEmployee(emp);
		Iterable<Employee> empList = service.getAllEmployees();
		map.put("empInfo", empList);
		map.put("resultMsg", result);
		return "employee_report";
	}
*/	

	@PostMapping("/edit_employee")
	public String editEmployee(HttpSession ses, @ModelAttribute("emp")Employee emp) {
		//use service
		String result = service.updateEmployee(emp);
		ses.setAttribute("resultMsg", result);
		return "redirect:emp_report";
	}
	
	
	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam int eno, Map<String, Object> map) {
		//use service
		String result = service.deleteEmployeeByEno(eno);
		Iterable<Employee> empList = service.getAllEmployees();
		map.put("resultMsg", result);
		map.put("empInfo", empList);
		return "employee_report";
	}
}

