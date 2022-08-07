package com.nt.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.control.ShoppingOperationsController;

@Component
public class BillingServiceRestConsumerLBC {

	@Autowired
	private LoadBalancerClient client;
	
	@Autowired
	private RestTemplate template;
	
	Logger logger = LoggerFactory.getLogger(BillingServiceRestConsumerLBC.class);	
	
	public String getBillingInfo() {
		logger.info("Get Billing details.");
		ServiceInstance si = client.choose("Billing-Service");
		String url = si.getUri()+"/billing/info";
		String resp = template.getForObject(url, String.class);
		return resp;
	}
}
