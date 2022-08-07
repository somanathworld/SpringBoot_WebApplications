package com.nt.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceRestConsumerLBC;

@RestController
@RequestMapping("/shopping")
public class ShoppingOperationsController {

	@Autowired
	private BillingServiceRestConsumerLBC consumer;
	
	Logger logger = LoggerFactory.getLogger(ShoppingOperationsController.class);
	
	
	@GetMapping("/info")
	public String shopping() {
		logger.info("Welcome to Shopping Module.");
		String resp = consumer.getBillingInfo();
		logger.info("Back to Shopping Module : "+resp);
		return resp;
	}
}
