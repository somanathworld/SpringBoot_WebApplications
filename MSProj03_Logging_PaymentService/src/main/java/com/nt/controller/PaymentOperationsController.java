package com.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentOperationsController {

	Logger logger = LoggerFactory.getLogger(PaymentOperationsController.class);
	
	@GetMapping("/info")
	public String doPayment() {
		logger.info("Welcome to Payment Module.");
		return "Payment is done.";
	}
}
