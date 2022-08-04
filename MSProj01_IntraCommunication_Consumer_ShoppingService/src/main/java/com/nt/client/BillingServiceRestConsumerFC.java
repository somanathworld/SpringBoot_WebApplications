package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Service")
public interface BillingServiceRestConsumerFC {

	@GetMapping("/billing/info")
	public String fetchBillDetails();
}
