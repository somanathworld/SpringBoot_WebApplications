package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsProj05MiniProjectIplPlayerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj05MiniProjectIplPlayerServiceApplication.class, args);
	}

}
