package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService service;

	@Autowired
	private EmployeeValidator validator;

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
		// user service
		Iterable<Employee> empList = service.getAllEmployees();
		map.put("empInfo", empList);
		return "employee_report";
	}

	@GetMapping("/insert_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.showAddEmployeeForm()");
		return "add_employee";
	}

	@PostMapping("/insert_employee")
	public String registerEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp,
			BindingResult errors) {
		System.out.println("EmployeeController.registerEmployee()");
		// validation logic
		if (emp.getVFlag().equalsIgnoreCase("no")) {
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);

				if (errors.hasErrors()) {
					return "add_employee";
				}
			}
		}

		// use service
		String result = service.insertEmployee(emp);
		attrs.addFlashAttribute("resultMsg", result);

		return "redirect:emp_report";
	}

	@GetMapping("/edit_employee")
	public String showEditEmployeeForm(@RequestParam Integer eno, @ModelAttribute("emp") Employee emp) {
		// use service
		Employee srcEmp = service.getEmployeeByEno(eno);
		BeanUtils.copyProperties(srcEmp, emp);
		return "modify_employee";
	}

	@PostMapping("/edit_employee")
	public String editEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		// use service
		String result = service.updateEmployee(emp);
		ses.setAttribute("resultMsg", result);
		return "redirect:emp_report";
	}

	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam int eno, Map<String, Object> map) {
		// use service
		String result = service.deleteEmployeeByEno(eno);
		Iterable<Employee> empList = service.getAllEmployees();
		map.put("resultMsg", result);
		map.put("empInfo", empList);
		return "employee_report";
	}
	
	
	//paging data
	@GetMapping("page_emp_report")
	public String showEmployeeReportPageWise(@PageableDefault(page = 0, size = 3, sort = "job", direction = Sort.Direction.ASC) Pageable pageable, Map<String, Object> map) {
		Page<Employee> empList = service.getEmployeePageData(pageable);
		map.put("pageData", empList);
		return "page_employee_report";
	}
}
