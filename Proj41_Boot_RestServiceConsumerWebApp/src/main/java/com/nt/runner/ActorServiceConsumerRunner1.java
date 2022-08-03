package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumerRunner1 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class object
		RestTemplate template = new RestTemplate();
		//Define service URL
		String serviceUrl = "http://localhost:3030/Proj41_Boot_RestServiceProviderApp/actor/wish";
		//Generate HTTP request with GET mode to consume the web service(API)
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);
		//display the recieved details from the respone
		System.out.println("Response Body(output) : "+response.getBody());
		System.out.println("Response Status Code : "+response.getStatusCode());
		System.out.println("Response Status Code Value : "+response.getStatusCodeValue());
	}
}
