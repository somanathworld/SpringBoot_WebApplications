package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

	@JmsListener(destination = "testmq1")
	public void readMessage(String text) {
		System.out.println("Received msg : "+text);
	}
}
