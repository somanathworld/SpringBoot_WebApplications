package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.IUserMgmtService;

@Controller
public class UserController {

	@Autowired
	private IUserMgmtService service;
	
	@GetMapping("/wish")
	public String getWishMessage(Map<String, Object> map, @RequestParam String user) {
		System.out.println("UserController.getWishMessage()");
		//use service
		String resultMsg = service.generateWishMessage(user);
		map.put("resultMsg", resultMsg);
		return "result_page";
	}
}
