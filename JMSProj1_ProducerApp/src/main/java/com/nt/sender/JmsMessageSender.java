package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageSender {

	@Autowired
	private JmsTemplate template;
	
	private int count = 0;

	@Scheduled(initialDelay = 1000, fixedDelay = 1000)
	public void SendMessage() {
		template.send("testmq1",(ses)->ses.createTextMessage("Send message @"+new Date()));
		System.out.println("Message Send."+(count++));		
	}
}
