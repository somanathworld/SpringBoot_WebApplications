package com.nt.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageSenderRunner implements CommandLineRunner{

	@Autowired
	private JmsTemplate template;

	@Override
	public void run(String... args) throws Exception {
		template.send("testmq1",(ses)->ses.createTextMessage("Send message @"+new Date()));
		System.out.println("Message Send.");
	}
}
