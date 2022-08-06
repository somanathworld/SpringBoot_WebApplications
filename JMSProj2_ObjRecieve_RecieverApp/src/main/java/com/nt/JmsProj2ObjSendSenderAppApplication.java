package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JmsProj2ObjSendSenderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsProj2ObjSendSenderAppApplication.class, args);
	}

}
