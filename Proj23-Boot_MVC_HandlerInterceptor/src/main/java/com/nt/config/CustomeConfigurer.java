package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TimeOutCheckInterceptor;

@Component
public class CustomeConfigurer implements WebMvcConfigurer{

	public CustomeConfigurer() {
		System.out.println("CustomeConfigurer.CustomeConfigurer()");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("CustomeConfigurer.addInterceptors()");
		registry.addInterceptor(new TimeOutCheckInterceptor());
	}
}
