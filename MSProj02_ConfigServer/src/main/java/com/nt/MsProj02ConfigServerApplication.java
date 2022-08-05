package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsProj02ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj02ConfigServerApplication.class, args);
	}

}
