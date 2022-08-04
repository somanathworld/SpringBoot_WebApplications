package com.nt.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumerDC {

	@Autowired
	private DiscoveryClient client;  //comes through AutoConfiguration
	
	public String getBillingInfo() {
		//find and get SErviceInstances  of Producer by using Service Id
		List<ServiceInstance> listSI =client.getInstances("Billing-Service");
		 // use  first ServiceInstance from the List of Instances
		ServiceInstance si = listSI.get(0);
		//get Producer MS URI  and make it  as URL
		String url = si.getUri()+"/billing/info";
		RestTemplate template = new RestTemplate();
		 // create RestTemplate object
		String resp = template.getForObject(url, String.class);
		// invoke producer MS service method or operation by generating Http call
		return resp;
	}
}
