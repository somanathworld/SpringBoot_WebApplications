package com.nt.sender;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.model.Actor;

@Component
public class ObjectMessageSender {

	@Autowired
	private JmsTemplate template;
	
	@Scheduled(cron = "0/5 * * * * *")
	public void SendObjectDataAsMessage() {
		List<String> nameList = List.of("Prince","Sai","Raja","Maharaja","Ramesh");
		List<String> addrsList = List.of("Hyd","Bangalore","Chennai","AP","UP");
		int actorId = 101;
		
		Actor actor = new Actor();
		for(int i = 0; i<10; i++)
			actor = new Actor(actorId++,
					nameList.get(new Random().nextInt(5)),
					addrsList.get(new Random().nextInt(5)));
		
		template.convertAndSend("obj_mq1",actor);
		System.out.println("Message send.");
	}
}
