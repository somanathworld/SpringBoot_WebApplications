package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/result")
	public String showResultPage(Map<String, Object> map) {
		map.put("data", new java.util.Date());
		return "result";
	}
}
