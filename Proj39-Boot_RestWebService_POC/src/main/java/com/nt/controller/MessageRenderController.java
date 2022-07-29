package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageRenderController {
	
	@GetMapping("/generate")
	public ResponseEntity<String> generateMessage() {
		LocalDateTime ldt = LocalDateTime.now();
		int hours = ldt.getHour();
		String body = null;
		if(hours < 12)
			body = "Good Morning";
		else if(hours < 18)
			body = "Good Afternoon";
		else
			body = "Good Evening";
		
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> entity = new ResponseEntity<String>(body+" User", status);
		return entity;
	}
}
