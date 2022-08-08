package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentOperationsController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public String doPayment() {
		return "From payment service, Port @"+port;
	}
	
}
