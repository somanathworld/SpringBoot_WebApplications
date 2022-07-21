package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Faculty;
import com.nt.service.IFacultyMgmtService;

@Controller
public class InstitutionOperationsController {

	@Autowired
	private IFacultyMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "homePageDef";
	}
	
	@GetMapping("/list_faculties")
	public  String  showFacultiesPage(Map<String,Object> map) {
		//use service
		Iterable<Faculty> itList=service.getAllFaculty();
		//model attribute
		map.put("facultiesList", itList);
		return "facultiesPageDef";
	}
	
	@GetMapping("/list_courses")
	public  String  showFacultiesPage() {
		return "coursesPageDef";
	}
	
	@GetMapping("/list_traning_modes")
	public  String  showTrainingModesPage() {
		return "trainingPageDef";
	}
}
