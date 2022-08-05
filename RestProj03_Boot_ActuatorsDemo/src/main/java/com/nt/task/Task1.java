package com.nt.task;

import org.springframework.scheduling.annotation.Scheduled;

public class Task1{

	@Scheduled(initialDelay = 2000, fixedDelay = 5000)
	public void run(String... args) throws Exception {
		System.out.println("task1");
	}
}
