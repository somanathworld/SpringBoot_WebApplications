package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.TouristNotFoundException;
import com.nt.model.ErrorDetails;

//@ControllerAdvice
@RestControllerAdvice
public class TouristErrorHandler {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException tnf){
		System.out.println("TouristErrorHandler.handleTouristNotFound()");
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), tnf.getMessage(), "404-Tourist Not Found.");
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception ex){
		System.out.println("TouristErrorHandler.handleAllProblems()");
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), "Problem in execution.");
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
