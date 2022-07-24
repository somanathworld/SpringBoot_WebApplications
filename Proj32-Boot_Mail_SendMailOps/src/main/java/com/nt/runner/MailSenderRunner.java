package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPurchaseOrder;

@Component
public class MailSenderRunner implements CommandLineRunner {

	@Autowired
	private IPurchaseOrder order;

	@Override
	public void run(String... args) throws Exception {
		try {
			String msg = order.purchase(new String[] { "Shirt", "Kurta", "Pant" },
					new double[] { 1000.0, 2000.0, 3999.0 }, new String[] { "somanathmishra1920@gmail.com" });
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
