package com.nt.service;

import javax.servlet.http.HttpServletResponse;

import com.nt.entity.MarriageSeekerInfo;
import com.nt.model.MarriageSeeker;

public interface IMatrimonyMgmtService {

	public String processProfile(MarriageSeeker seeker) throws Exception;
	public String registerProfile(MarriageSeekerInfo info);
	public Iterable<MarriageSeekerInfo> displayAllProfiles();
	public void getFile(String filePath, HttpServletResponse res)throws Exception;
}
