package com.nt.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentServiceRestConsumerLBC {

	@Autowired
	private LoadBalancerClient client;
	
	@Autowired
	private RestTemplate template;
	
	Logger logger = LoggerFactory.getLogger(PaymentServiceRestConsumerLBC.class);	
	
	public String getPaymentInfo() {
		logger.info("Get Payment details.");
		ServiceInstance si = client.choose("Payment-Service");
		String url = si.getUri()+"/payment/info";
		String resp = template.getForObject(url, String.class);
		return resp;
	}
}
