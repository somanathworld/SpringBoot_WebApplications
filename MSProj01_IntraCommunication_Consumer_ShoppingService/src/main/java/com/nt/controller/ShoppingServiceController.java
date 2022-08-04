package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceRestConsumerFC;
import com.nt.client.BillingServiceRestConsumerLBC;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceController {

	@Autowired
//	private BillingServiceRestConsumerDC consumer;
//	private BillingServiceRestConsumerLBC consumer;
	private BillingServiceRestConsumerFC consumer;
	
	@GetMapping("/info")
	public String displayShoppingDetails() {
//		return "Pongal shopping for family...."+consumer.getBillingInfo();
		return "Pongal shopping for family...."+consumer.fetchBillDetails();
	
	}
	
}
