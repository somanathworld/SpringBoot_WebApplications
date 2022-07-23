package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.UserDetails;
import com.nt.service.IUserMgmtService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserMgmtService service;
	
	public UserController() {
		System.out.println("UserController.UserController()");
	}
	
	@GetMapping("/showLogin")
	public String showLoginPage() {
		System.out.println("UserController.showLoginPage()");
		return "custom_login";
	}

	@GetMapping("/register")
	public String showUserRegistrationForm(@ModelAttribute("userInfo") UserDetails details) {
		System.out.println("UserController.showUserRegistrationForm()");
		return "user_register";
	}
	
	@PostMapping("/register")
	public String registerUser(Map<String, Object>map, 
								@ModelAttribute("user") UserDetails details) {
		//use service
		String resultMsg = service.register(details);
		map.put("msg", resultMsg);
		return "result";
	}
}
