package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Proj42BootRestMiniProjectConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj42BootRestMiniProjectConsumerApplication.class, args);
	}
	
	@Bean("template")
	public RestTemplate createTemplate() {
		return new RestTemplate();
	}

}
