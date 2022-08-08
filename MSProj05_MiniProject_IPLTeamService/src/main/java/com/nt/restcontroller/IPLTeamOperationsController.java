package com.nt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLTeamInfo;
import com.nt.service.IIPLTeamMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team")
@Slf4j
public class IPLTeamOperationsController {

	@Autowired
	private IIPLTeamMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveIPLTEam(@RequestBody IPLTeamInfo info){
		String resultMsg = service.registerIPLTeam(info);
		log.info("Saving IPL Team.");
		return ResponseEntity.ok(resultMsg);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLTeamInfo> fetchTeamInfoById(@PathVariable Integer id){
		IPLTeamInfo info = service.findIPLTeam(id);
		System.out.println(info);
		log.info("Fetching IPL Team details by id : "+id);
		return ResponseEntity.ok(info);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPLTeamInfo>> fetchAllTeaInfo(){
		List<IPLTeamInfo> teamList = service.findAllIPLTeamDetails();
		log.info("Fetching All IPL Teams details.");
		return ResponseEntity.ok(teamList);
	}
}

