package com.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.PaymentServiceRestConsumerLBC;

@RestController
@RequestMapping("/billing")
public class BillingOperationsController {
	
	@Autowired
	private PaymentServiceRestConsumerLBC consumer;
	
	Logger logger = LoggerFactory.getLogger(BillingOperationsController.class);
	
	@GetMapping("/info")
	public String doBilling() {
		logger.info("Welcome to Billing Service.");
		String resp = consumer.getPaymentInfo();
		logger.info("Back to Billing module : "+resp);
		return resp;
	}

}
