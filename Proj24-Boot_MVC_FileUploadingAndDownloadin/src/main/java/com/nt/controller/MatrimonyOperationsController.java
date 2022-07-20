package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.MarriageSeekerInfo;
import com.nt.model.MarriageSeeker;
import com.nt.service.IMatrimonyMgmtService;

@Controller
public class MatrimonyOperationsController {

	@Autowired
	private IMatrimonyMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("MatrimonyOperationsController.showHomePage()");
		return "home";
	}
	
	@GetMapping("/register")
	public String showProfileFormPage(@ModelAttribute("profile") MarriageSeeker seeker) {
		System.out.println("MatrimonyOperationsController.showProfileFormPage() : "+seeker);
		return "marriage_seeker_register";
	}
	
	@PostMapping("/register")
	public String processProfileFormPage(@ModelAttribute("seeker") MarriageSeeker seeker, Map<String, Object> map) throws Exception{
		System.out.println("MatrimonyOperationsController.processProfileFormPage() : "+seeker);
		String msg = service.processProfile(seeker);
		map.put("resultMsg", msg);
		return "show_result";
	} 
	
	@GetMapping("/display")
	public String displayProfiles(Map<String, Object> map) {
		System.out.println("MatrimonyOperationsController.displayProfiles()");
		Iterable<MarriageSeekerInfo> seekersInfo = service.displayAllProfiles();
		map.put("seekersInfo", seekersInfo);
		return "display_marriage_profiles";
	}
	
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/download")
	public String downloadFiles(@RequestParam("file") String filePath, HttpServletResponse res) throws Exception{
		System.out.println("MatrimonyOperationsController.downloadFiles()");
		service.getFile(filePath, res);
		System.out.println("file downloaded.");
		return null;
	}
}
