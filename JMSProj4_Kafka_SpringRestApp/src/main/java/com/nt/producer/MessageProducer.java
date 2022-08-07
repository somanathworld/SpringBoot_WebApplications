package com.nt.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.nt.model.Student;

@Component
public class MessageProducer {

	@Autowired
	private KafkaTemplate<String, String> msgTemplate;

	@Autowired
	private KafkaTemplate<String, Student> objTemplate;
	
	@Value("${app.topic.name}")
	private String topicName;
	
	public String sendMessage(String message) {
		msgTemplate.send(topicName,message);
		return "message delivered.";
	}

	public String sendObject(Student stud) {
		objTemplate.send(topicName,stud);
		return "message delivered.";
	}
}
