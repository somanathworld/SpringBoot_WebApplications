package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLPlayerInfo;
import com.nt.service.IPlayerMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player")
@Slf4j
public class IPLPlayerOperationsController {

	@Autowired
	private IPlayerMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveIPLPlayer(@RequestBody IPLPlayerInfo player){
		String result = service.registerPlayer(player);
		log.info("Player details are saved with id :: "+player.getPid());
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPLPlayerInfo>> fetchAllPlayerInfo(){
		List<IPLPlayerInfo> list = service.findAllPlayersInfo();
		log.info("Retriving all players info.");
		return ResponseEntity.ok(list);
	}
}
