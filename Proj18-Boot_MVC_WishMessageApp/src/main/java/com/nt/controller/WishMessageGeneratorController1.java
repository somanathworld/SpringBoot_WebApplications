package com.nt.controller;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageGeneratorController1 {

	@Autowired
	private IWishMessageService service;
	
	public WishMessageGeneratorController1() {
		System.out.println("WishMessageGeneratorController1.WishMessageGeneratorController1()");
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String generateMessage_get() {
		System.out.println("WishMessageGeneratorController1.generateMessage_get()");
		return "show_get";
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String generateMessage_post() {
		System.out.println("WishMessageGeneratorController1.generateMessage_post()");
		return "show_post";
	}

	@RequestMapping(value = {"/display", "/print", "/check"}, method = RequestMethod.GET)
	public String generateMultiUrlMsg() {
		System.out.println("WishMessageGeneratorController1.generateMultiUrlMsg()");
		return "print";
	}
	
	@Autowired
	private ServletContext sc;
	@Autowired
	private ServletConfig cfg;
	@Autowired
	private HttpSession ses;
	
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String getServerObjects(Map<String, Object> map) {
		System.out.println("WishMessageGeneratorController1.getServerObjects()");
		map.put("serCtx", sc);
		map.put("serCfg", cfg);
		map.put("ses", ses);				
		return "demo";
	}
}
