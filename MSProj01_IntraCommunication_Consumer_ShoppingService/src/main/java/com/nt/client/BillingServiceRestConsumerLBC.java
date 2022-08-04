package com.nt.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumerLBC {

	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo() {
		//get LessLoadFactor Service instance
		ServiceInstance si = client.choose("Billing-Service");
		//get Producer MS URI and make it as URL
		String url = si.getUri()+"/billing/info";
		//create RestTemplate obj
		RestTemplate template = new RestTemplate();
		//invoke Producer MS service method or operation by generating Http Call
		String resp = template.getForObject(url, String.class);
		
		return resp;
	}
}
