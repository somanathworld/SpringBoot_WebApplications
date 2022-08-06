package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.Actor;

@Component
public class ObjectMessageReciever {

	@JmsListener(destination = "obj_mq1")
	public void consumeObjectDataAsMessage(Actor actor) {
		System.out.println("Received object data : "+actor);
	}
}
