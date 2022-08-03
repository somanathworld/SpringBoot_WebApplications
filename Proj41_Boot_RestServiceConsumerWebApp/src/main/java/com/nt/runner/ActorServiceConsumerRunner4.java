package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumerRunner4 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate obj
		RestTemplate template = new RestTemplate();
		
		System.out.println("==================Get Request==================");
		//Define service url
		String serviceUrl = "http://localhost:3030/Proj41_Boot_RestServiceProviderApp/actor/wish";
		//make Http call using exchange() method
		ResponseEntity<String> response1 = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		//display the received details from the response
		System.out.println("Response Body(output) : "+response1.getBody());
		System.out.println("Response status code : "+response1.getStatusCode());
		System.out.println("Response status code value : "+response1.getStatusCodeValue());

		System.out.println("\n\n==================Get Request with path variable==================");		
		//Define service url
		serviceUrl = "http://localhost:3030/Proj41_Boot_RestServiceProviderApp/actor/wish/{id}/{name}";
		//make Http call using exchange() method
		ResponseEntity<String> response2 = template.exchange(serviceUrl, HttpMethod.GET, null, String.class,101,"Raja");
		//display the received details from the response
		System.out.println("Response Body(output) : "+response2.getBody());
		System.out.println("Response status code : "+response2.getStatusCode());
		System.out.println("Response status code value : "+response2.getStatusCodeValue());

		System.out.println("\n\n==================Post Request==================");
		//Define service url
		serviceUrl = "http://localhost:3030/Proj41_Boot_RestServiceProviderApp/actor/register";
		HttpHeaders headers = new HttpHeaders();
		//prepare JSON data
		String json_body = "		 {\r\n"
				+ "		 	\"aid\" : 1,\r\n"
				+ "		 	\"name\" : \"Raja\",\r\n"
				+ "		 	\"age\" : 24,\r\n"
				+ "		 	\"type\" : \"Hero\"\r\n"
				+ "		 }\r\n";
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare http request as HttpEntity obj
		HttpEntity<String> entity = new HttpEntity<>(json_body,headers);
		//make Http call using exchange() method
		ResponseEntity<String> response3 = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
		//display the received details from the response
		System.out.println("Response Body(output) : "+response3.getBody());
		System.out.println("Response headers : "+response3.getHeaders());
		System.out.println("Response status code : "+response3.getStatusCode());
		System.out.println("Response status code value : "+response3.getStatusCodeValue());
	
		System.exit(0);
	}
}
