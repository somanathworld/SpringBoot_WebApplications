package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumerRunner3 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class object
		RestTemplate template = new RestTemplate();
		//Define service URL
		String serviceUrl = "http://localhost:3030/Proj41_Boot_RestServiceProviderApp/actor/register";
		//prepare JSON data(request body)
		String json_body=" {\r\n"
				+ " 	\"aid\":1001,\r\n"
				+ " 	\"name\":\"suresh\",\r\n"
				+ " 	\"age\":30,\r\n"
				+ " 	\"type\":\"hero\"\r\n"
				+ " }";	
		//prepare header 
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		//prepare HTTP request as HttpEntity obj having head, body
		HttpEntity<String> request = new HttpEntity<String>(json_body, header);
		//Generate HTTP request with GET mode to consume the web service(API)
		ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String.class);
		//display the recieved details from the respone
		System.out.println("Response Body(output) : "+response.getBody());
		System.out.println("Response header : "+response.getHeaders());
		System.out.println("Response Status Code : "+response.getStatusCode());
		System.out.println("Response Status Code Value : "+response.getStatusCodeValue());
		
		System.exit(0);
	}
}
