package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.consumer.IPLTeamServiceConsumer;
import com.nt.model.IPLPlayerInfo;
import com.nt.model.IPLTeamInfo;
import com.nt.repository.IIPLPalayerInfoRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlayerMgmtServiceImpl implements IPlayerMgmtService{

	@Autowired
	private IIPLPalayerInfoRepo playerRepo;
	
	@Autowired
	private IPLTeamServiceConsumer consumer;
	
	@Override
	public String registerPlayer(IPLPlayerInfo player) {
		//Consumer MS is consuming Team Microservice through Feign Client
		IPLTeamInfo team = consumer.findIPLTeamById(player.getTeam().getTeamId()).getBody();
		System.out.println(team);
		log.info("TeamInfo is gathered from other Producer Ms");
		//assign team object with player object
		player.setTeam(team);
		int idVal = playerRepo.save(player).getPid();
		log.info("saving player details with generated id value : "+idVal);
		return "Player and his team details saved having the player id : "+idVal;
	}
	
	@Override
	public List<IPLPlayerInfo> findAllPlayersInfo() {
		log.info("All Player info is gathered.");
		return playerRepo.findAll();
	}
}
