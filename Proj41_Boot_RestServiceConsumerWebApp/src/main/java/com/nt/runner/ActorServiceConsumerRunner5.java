package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ActorServiceConsumerRunner5 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate obj
		RestTemplate template = new RestTemplate();
		
		System.out.println("==================Get Request==================");
		//Define service url
		String serviceUrl = "http://localhost:3030/Proj41_Boot_RestServiceProviderApp/actor/findAll";
		//make Http call using exchange() method
		ResponseEntity<String> response1 = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		//display the received details from the response
		System.out.println("Response Body(output) : "+response1.getBody());
		System.out.println("Response status code : "+response1.getStatusCode());
		System.out.println("Response status code value : "+response1.getStatusCodeValue());

		//convert JSON text response to java class object/Model class obj using JACKSON api
		String jsonBody1 = response1.getBody();
		ObjectMapper mapper1 = new ObjectMapper();
		Actor[] actors = mapper1.readValue(jsonBody1, Actor[].class);
		List<Actor> actorList = Arrays.asList(actors);
		actorList.forEach(System.out::println);
		System.exit(0);
	}
}
