package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class UserMgmtServiceImpl implements IUserMgmtService{

	@Override
	public String generateWishMessage(String user) {
		LocalDateTime ldt = LocalDateTime.now();
		int hours = ldt.getHour();
		String resultMsg = "";
		if(hours < 12)
			resultMsg = "Good Morning : "+user;
		else if(hours < 18)
			resultMsg = "Good Afternoon : "+user;
		else
			resultMsg = "Good Evening : "+user;
		
		return resultMsg;
			
	}
}
