package com.nt.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nt.model.Student;

@Component
public class MessageStore {

	private List<String> listMessages = new ArrayList<>();
	
	public void addMessage(String message) {
		listMessages.add(message);
	}
	
	public String getAllMessages() {
		return listMessages.toString();
	}

	private List<Student> listObjects = new ArrayList<>();
	
	public void addObject(Student stud) {
		listObjects.add(stud);
	}
	
	public String getAllObjects() {
		return listObjects.toString();
	}
	
}
