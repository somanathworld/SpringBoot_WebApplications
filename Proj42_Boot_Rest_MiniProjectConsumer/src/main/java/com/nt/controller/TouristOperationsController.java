package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.entity.Tourist;

@Controller
public class TouristOperationsController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	
	@GetMapping("/list_tourists")
	public String displayTouristDetails(Map<String, Object> map) throws Exception {		
		System.out.println("TouristOperationsController.displayTouristDetails()");
		
		//consume   SpringRest Service/method/operation
		 /*  url/uri ::  http://localhost:3030/Proj40_Boot_Rest_MiniProject/tourist/findAll
		  *  method ::  GET
		  *  response  Content type :: applicaiton/json (default)
		  *  No path variables/ No Query String
		  *  No  headers, body required
		  */
		String serviceUrl = "http://localhost:3030/Proj40_Boot_Rest_MiniProject/tourist/findAll";
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		String jsonRespBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Tourist> touristList = mapper.readValue(jsonRespBody, new TypeReference<List<Tourist>>() {});
		map.put("touristList", touristList);
		return "tourist_report";
	}
	
	@GetMapping("/add")
	public String showTouristRegistrationForm(@ModelAttribute("tst") Tourist tourist) {
		return "add_tourist";
	}
	
	@PostMapping("/add")
	public String registerTourist(@ModelAttribute("tst") Tourist tourist,
									RedirectAttributes attrs) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(tourist);
		
		String serviceUrl = "http://localhost:3030/Proj40_Boot_Rest_MiniProject/tourist/register";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, header);
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST,entity, String.class);
		String resultMsg = response.getBody();
		attrs.addFlashAttribute("resultMsg", resultMsg);
		return "redirect:list_tourists";
	}
	
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("id") Integer tid, @ModelAttribute("tst")Tourist tourist) throws Exception {
		String serviceUrl = "http://localhost:3030/Proj40_Boot_Rest_MiniProject/tourist/find/{id}";
		ResponseEntity<String> resp = template.exchange(serviceUrl, HttpMethod.GET, null, String.class, tid);
		String jsonBody = resp.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Tourist tourist1 = mapper.readValue(jsonBody, Tourist.class);
		BeanUtils.copyProperties(tourist1, tourist);
		return "edit_tourist";
	}
	
	@PostMapping("/edit")
	public String editTourist(@ModelAttribute("tst")Tourist tourist, RedirectAttributes attrs) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(tourist);
		String serviceUrl = "http://localhost:3030/Proj40_Boot_Rest_MiniProject/tourist/modify";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(jsonBody,headers);
		ResponseEntity<String> resp = template.exchange(serviceUrl, HttpMethod.PUT, entity, String.class);
		String result = resp.getBody();
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:list_tourists";
	}
	
	
	@GetMapping("/delete")
	public String deleteTourist(@RequestParam("id") Integer tid, RedirectAttributes attrs) {
		String serviceUrl = "http://localhost:3030/Proj40_Boot_Rest_MiniProject/tourist/delete/{id}";
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.DELETE, null, String.class, tid);
		String result = response.getBody();
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:list_tourists";
	}
}
