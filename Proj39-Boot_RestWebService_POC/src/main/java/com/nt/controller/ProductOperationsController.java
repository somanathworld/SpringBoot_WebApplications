package com.nt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Product;

@RestController
@RequestMapping("/product")
public class ProductOperationsController {

	@PostMapping("/register")
	public String registerCustomer(@RequestBody Product prod) {
		return prod.toString();
	}
}
