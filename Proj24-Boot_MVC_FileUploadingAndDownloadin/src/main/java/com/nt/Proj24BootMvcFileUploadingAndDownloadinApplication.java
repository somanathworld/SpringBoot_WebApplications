package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class Proj24BootMvcFileUploadingAndDownloadinApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj24BootMvcFileUploadingAndDownloadinApplication.class, args);
	}
	
	public CommonsMultipartResolver createCMResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		resolver.setMaxUploadSizePerFile(100*1024);
		resolver.setPreserveFilename(true);
		return resolver;
	}

}
