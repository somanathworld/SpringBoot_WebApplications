package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.IPLTeamInfo;
import com.nt.repository.IIPLTeamInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {

	@Autowired
	private IIPLTeamInfoRepository teamRepo;
	
	@Override
	public String registerIPLTeam(IPLTeamInfo team) {
		int idVal = teamRepo.save(team).getTeamId();
		log.info("IPL Team is registered sucessfully with id : "+idVal);
		return "Team is registered with id : "+idVal;
	}

	@Override
	public IPLTeamInfo findIPLTeam(int teamId) {
		log.info("Getting IPL Team info by id : "+teamId);
		return teamRepo.findById(teamId).get();
	}

	@Override
	public List<IPLTeamInfo> findAllIPLTeamDetails() {
		log.info("Getting all IPL Team details.");
		return teamRepo.findAll();
	}

}
