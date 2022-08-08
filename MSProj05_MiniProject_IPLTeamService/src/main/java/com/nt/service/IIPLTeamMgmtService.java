package com.nt.service;

import java.util.List;

import com.nt.model.IPLTeamInfo;

public interface IIPLTeamMgmtService {

	public String registerIPLTeam(IPLTeamInfo team);
	public IPLTeamInfo findIPLTeam(int teamId);
	public List<IPLTeamInfo> findAllIPLTeamDetails();
}
