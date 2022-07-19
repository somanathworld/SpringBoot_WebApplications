package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.binder.LocalDateEditor;
import com.nt.binder.LocalDateTimeEditor;
import com.nt.binder.LocalTimeEditor;
import com.nt.model.Cricketer;
import com.nt.service.ICricketerMgmtService;

@Controller
public class CricketerController {

	@Autowired
	private ICricketerMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("CricketerController.showHomePage()");
		return "home";
	}
	
	@GetMapping("/register")
	public String showCricketerRegistrationPage(@ModelAttribute("crck")Cricketer crck) {
		System.out.println("CricketerController.showCricketerRegistrationPage() : "+crck);
		return "cricketer_register";
	}
	
	@PostMapping("/register")
	public String registerCricketer(Map<String, Object>map, 
									@ModelAttribute("cktr") Cricketer cktr,
									BindingResult errors) {
		System.out.println("CricketerController.registerCricketer() : "+cktr);
		String msg = service.registerCricketer(cktr);
		map.put("resultMsg", msg);
		return "show_result";
	}
	
	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		System.out.println("CricketerController.myInitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(java.util.Date.class, editor);
		
		System.out.println("registering Custom Property Editor");
		binder.registerCustomEditor(java.time.LocalDate.class, new LocalDateEditor());
		binder.registerCustomEditor(java.time.LocalTime.class, new LocalTimeEditor());
		binder.registerCustomEditor(java.time.LocalDateTime.class, new LocalDateTimeEditor());
		
	}
}
