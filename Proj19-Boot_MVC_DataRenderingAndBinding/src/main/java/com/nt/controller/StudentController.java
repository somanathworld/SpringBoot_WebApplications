package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.mode.Student;

@Controller
public class StudentController {

	public StudentController() {
		System.out.println("StudentController.StudentController()");
	}
	
	@GetMapping("/register_stud")
	public String showForm(@ModelAttribute("st")Student stud) {
		System.out.println("StudentController.showForm() : "+stud.toString());
		return "stud_registration_form";
	}
	
	@PostMapping("/register_stud")
	public String registerStudent(Map<String, Object> map, @ModelAttribute("stud")Student studInfo) {
		System.out.println("StudentController.registerStudent()");
		System.out.println(studInfo);
		map.put("studInfo", studInfo);
		return "stud_result";
	}
	
	
}
