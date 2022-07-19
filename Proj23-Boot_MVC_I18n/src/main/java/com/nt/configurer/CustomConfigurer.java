package com.nt.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Component
public class CustomConfigurer implements WebMvcConfigurer{

	@Autowired
	private LocaleChangeInterceptor interceptor;
	
	public CustomConfigurer() {
		System.out.println("CustomConfigurer.CustomConfigurer()");	
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("CustomConfigurer.addInterceptors()");
		registry.addInterceptor(interceptor);
	}
	
	
}
