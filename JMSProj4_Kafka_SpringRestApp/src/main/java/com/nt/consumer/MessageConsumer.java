package com.nt.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nt.model.Student;

@Component
public class MessageConsumer {

	@Autowired
	private MessageStore store;
	
	@KafkaListener(topics = "${app.topic.name}",groupId = "grp1_consumers")
	public void readMessage(String message) {
		System.out.println("msg : "+message);
		store.addMessage(message);
	}

	//activate for object sending operation
//	@KafkaListener(topics = "${app.topic.name}",groupId = "grp1_consumers")
//	public void readObject(Student stu) {
//		System.out.println("msg : "+stu);
//		store.addObject(stu);
//	}
	
}
