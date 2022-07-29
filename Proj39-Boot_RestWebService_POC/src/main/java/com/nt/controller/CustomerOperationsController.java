package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showDetails(){
		Customer cust = new Customer(101, "Raja", 12000.0F, 
										new String[] {"Red", "Blue", "Black"},
										List.of("10th", "+2", "Bsc","MCA"),
										Set.of(234523453L,345234523L),
										Map.of("aadhar", 364564564L, "panNo", 456456346L),
										new Company("SAMSUNG", "Hyd","Electronics",3000)										
										);
		
		HttpStatus status = HttpStatus.OK;
	
		return new ResponseEntity<Customer>(cust, status);
	}	

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(){
		return new ResponseEntity<String>("From POST-registerCustomer() method", HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomer(){
		return new ResponseEntity<String>("From PUT-updateCustomer() method", HttpStatus.OK);
	}

	@PatchMapping("/pmodify")
	public ResponseEntity<String> updateCustomerByNo(){
		return new ResponseEntity<String>("From PATCH-updateCustomerByNo() method", HttpStatus.OK);
	}
	
	@DeleteMapping("/pmodify")
	public ResponseEntity<String> deleteCustomer(){
		return new ResponseEntity<String>("From DELETE-deleteCustomer() method", HttpStatus.OK);
	}	

}
