package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationsController {
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("BankOperationsController.showHomePage()");
		return "home";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		System.out.println("BankOperationsController.showOffers()");
		return "offers";
	}
	@GetMapping("/balance")
	public String checkBalance(Map<String, Object> map) {
		System.out.println("BankOperationsController.checkBalance()");
		map.put("bal_amt", new Random().nextInt(1000000));
		return "show_balance";
	}

	@GetMapping("/loanApprove")
	public String approveLoan(Map<String, Object> map) {
		System.out.println("BankOperationsController.approveLoan()");
		map.put("loan_amt", new Random().nextInt(1000000));
		return "loan";
	}
	
	@GetMapping("/denied")
	public String accessDenied(Map<String, Object> map) {
		System.out.println("BankOperationsController.accessDenied()");
		map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		return "access_denied";
	}
}
