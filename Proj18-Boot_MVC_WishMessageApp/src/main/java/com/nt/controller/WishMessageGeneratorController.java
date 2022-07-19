package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageGeneratorController {

	@Autowired
	private IWishMessageService service;
	
	public WishMessageGeneratorController() {
		System.out.println("WishMessageGeneratorController.WishMessageGeneratorController()");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		System.out.println("WishMessageGeneratorController.showHomePage()");
		return "home";
	}

	/*
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public ModelAndView generateMessage() {
		System.out.println("WishMessageGeneratorController.generateMessage()");
		String resultMsg = service.generateWishMessage("Rocky");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("wMsg", resultMsg);
//		mav.setViewName("display");
//		return mav;
		
		return new ModelAndView("display", "wMsg", resultMsg);
	}
	*/
	
/*
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public String generateMessage(BindingAwareModelMap map) {
		System.out.println("WishMessageGeneratorController.generateMessage()"+map.getClass());
		String resultMsg = service.generateWishMessage("Rocky");
		map.addAttribute("wMsg", resultMsg);
		return "display";
	}
*/	
/*
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public String generateMessage(ModelMap map) {
		System.out.println("WishMessageGeneratorController.generateMessage()"+map.getClass());
		String resultMsg = service.generateWishMessage("Rocky");
		map.addAttribute("wMsg", resultMsg);
		return "display";
	}
*/	
	
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public String generateMessage(Map<String, Object> map) {
		System.out.println("WishMessageGeneratorController.generateMessage()"+map.getClass());
		String resultMsg = service.generateWishMessage("Rocky");
		map.put("wMsg", resultMsg);
		return "display";
	}

/*	
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public String generateMessage(Model model) {
		System.out.println("WishMessageGeneratorController.generateMessage()"+model.getClass());
		String resultMsg = service.generateWishMessage("Rocky");
		model.addAttribute("wMsg", resultMsg);
		return "display";
	}
*/	
/*	//if we take return type as void it take incoming request path as LVN or view comp name(i.e. "wish")
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public void generateMessage(Model model) {
		System.out.println("WishMessageGeneratorController.generateMessage()"+model.getClass());
		String resultMsg = service.generateWishMessage("Rocky");
		model.addAttribute("wMsg", resultMsg);
	}
*/
/*	
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public void generateMessage(ServletResponse res) throws IOException {
		System.out.println("WishMessageGeneratorController.generateMessage()"+res.getClass());
		String resultMsg = service.generateWishMessage("Rocky");
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		writer.println("<b>Wish Message : </b>"+resultMsg);
		return;
	}
*/
/*
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public void generateMessage(ServletResponse res) throws IOException {
		System.out.println("WishMessageGeneratorController.generateMessage()"+res.getClass());
		String resultMsg = service.generateWishMessage("Rocky");
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		writer.println("<b>Wish Message : </b>"+resultMsg);
		return;
	}
*/	
}
