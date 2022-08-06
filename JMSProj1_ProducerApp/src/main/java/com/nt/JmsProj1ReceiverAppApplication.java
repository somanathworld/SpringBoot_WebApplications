package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JmsProj1ReceiverAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsProj1ReceiverAppApplication.class, args);
	}

}
