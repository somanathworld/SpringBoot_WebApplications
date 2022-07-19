package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishMessageService{

	@Override
	public String generateWishMessage(String user) {
		
		int hours = LocalDateTime.now().getHour();
		String wishMessage = null;
		
		if(hours <= 12) {
			wishMessage = "Good Morning : "+user;
		}else if(hours <= 18){
			wishMessage = "Good Afternoon : "+user;
		}else {
			wishMessage = "Good Evening : "+user;
		}
		
		return wishMessage;
	}
}
