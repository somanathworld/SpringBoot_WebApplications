package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsProj01IntraCommunicationEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj01IntraCommunicationEurekaServerApplication.class, args);
	}

}
