package com.nt;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@SpringBootApplication
public class Proj25BootMvcViewResolverCfgsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj25BootMvcViewResolverCfgsApplication.class, args);
	}

//	//ResourceBundle view resolver with view chaining with InternalResourceViewResolver	
//	@Bean()
//	public ResourceBundleViewResolver createRBVResolver() {
//		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
//		resolver.setBasename("com/nt/commons/view");
//		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return resolver;
//	}
	
	@Autowired
	private ServletContext sc;
	
//	@Bean
//	public XmlViewResolver createXVR() {
//		XmlViewResolver resolver = new XmlViewResolver();
//		resolver.setLocation(new FileSystemResource(sc.getRealPath("/")+"/WEB-INF/views.xml"));
//		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return resolver;
//	}

	
	@Bean
	public BeanNameViewResolver createViewResolver() {
		System.out.println("Proj25BootMvcViewResolverCfgsApplication.createViewResolver()");
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}
}
