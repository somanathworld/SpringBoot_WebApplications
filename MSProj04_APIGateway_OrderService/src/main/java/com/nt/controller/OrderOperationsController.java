package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderOperationsController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public String showOrderInfo() {
		return "From order service, Port @"+port;
	}
}
