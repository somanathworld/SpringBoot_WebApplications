package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestProj03BootActuatorsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestProj03BootActuatorsDemoApplication.class, args);
	}

}
