package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DifferentViewController {

//	@GetMapping("/")
	public String showHomePage() {
		System.out.println("DifferentViewController.showHomePage()");
		return "home";
	}
	
	@GetMapping("/welcome")
	public String showWelcomePage() {
		System.out.println("DifferentViewController.showWelcomePage()");
		return "view1";
	}
	
	@GetMapping("/display")
	public String showDisplayPage() {
		System.out.println("DifferentViewController.showDisplayPage()");
		return "view2";
	}
}
