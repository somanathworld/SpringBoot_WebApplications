package com.nt.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RoutingConfigApp {

//	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("paymentId", r->r.path("/payment/**").uri("http://localhost:9900"))
				.route("orderId", r->r.path("/order/**").uri("lb://Order-Service"))
				.build();
	}
}
