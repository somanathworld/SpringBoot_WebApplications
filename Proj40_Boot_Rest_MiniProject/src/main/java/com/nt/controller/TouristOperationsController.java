package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Tourist;
import com.nt.service.ITouristMgmtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tourist")
@Api("For Touris Operation")
public class TouristOperationsController {

	@Autowired
	private ITouristMgmtService service;

	@GetMapping("/")
	@ApiOperation("For Touris registration")
	public String showHomePage() {
		return "Tourist Operations Controller Home Page...";
	}

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		try {
			String result = service.registerTourist(tourist);
			return new ResponseEntity<String>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourists() {
		try {
			List<Tourist> list = service.fetchAllTorists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer tid) {
		try {
			Tourist tourist = service.fetchTouristById(tid);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
		try {
			String result = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable("id") Integer tid) {
		try {
			String result = service.deleteTorist(tid);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> removeTourist(@PathVariable("id") Integer tid,
			@PathVariable("hike") Float hikePercentage) {
		try {
			String result = service.updateTouristBudgetById(tid, hikePercentage);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//for error/exception handler
	@GetMapping("/search/{id}")
	public ResponseEntity<?> displayTouristById1(@PathVariable("id") Integer tid) throws Exception {
		System.out.println("TouristOperationsController.displayTouristById1()--before");
		Tourist tourist = service.fetchTouristById(tid);
		System.out.println("TouristOperationsController.displayTouristById1()--after");
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
	}

}
