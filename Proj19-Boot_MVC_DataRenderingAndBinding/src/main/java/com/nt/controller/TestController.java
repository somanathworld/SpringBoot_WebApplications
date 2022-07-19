package com.nt.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.mode.Employee;

@Controller
public class TestController {

	//prefer tomcat-embedded-jasper of 9.0.52 version
	@RequestMapping(value = "/report_sv", method = RequestMethod.GET)
	public String showReport_simpleValues(Map<String, Object> map) {
		System.out.println("TestController.showReport_simpleValues()");
		map.put("name", "Raja");
		map.put("age", 26);
		map.put("gender", 'M');
		return "show_report_simplevalues";
	}

	@RequestMapping(value = "/report_cv", method = RequestMethod.GET)
	public String showReport_collectionValues(Map<String, Object> map) {
		System.out.println("TestController.showReport_collectionValues()");
		String nickNames[] = new String[] {"Raja", "Rani", "Prince", "Maharaja"};
		Set<Long> phoneSet = new HashSet<>();
		phoneSet.add(9876543210L); phoneSet.add(1123456789L); phoneSet.add(6789054321L);
		List<String> courseList = List.of("Java", ".Net","Python");
		Map<String, Long> idsMap = Map.of("Adhaar", 876543210987L,"voterid",4342353553L,"panNo",253452345L);
		
		map.put("nickNames", nickNames);
		map.put("phonseInfo", phoneSet);
		map.put("courseInfo", courseList);
		map.put("idsInfo", idsMap);
		return "show_report_collectionvalues";
	}
	
	@RequestMapping(value = "/report_lmo")
	public String showReport_listOfModelObjects(Map<String, Object> map) {
		System.out.println("TestController.showReport_listOfModelObjects()");
		List<Employee> empList = List.of(
									new Employee(101,"Raja", "IT", 50000.0),
									new Employee(102, "Rani", "HR", 70000.0),
									new Employee(103,"Ramesh", "SD",90000.0)
									);
		map.put("empsInfo", empList);
		return "show_report_listmodelobjs";
	}

	@RequestMapping(value = "/report_mo")
	public String showReport_ModelObject(Map<String, Object> map) {
		System.out.println("TestController.showReport_ModelObject()");
		Employee emp = new Employee(101,"Raja", "IT", 50000.0);
		map.put("empInfo", emp);
		return "show_report_modelobj";
	}
	
}
