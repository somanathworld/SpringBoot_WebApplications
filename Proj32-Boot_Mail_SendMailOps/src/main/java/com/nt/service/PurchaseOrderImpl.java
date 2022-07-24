package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderImpl implements IPurchaseOrder{
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails) throws Exception {
		//calaculate bill amt
		double billAmt = 0;
		for(double price : prices) {
			billAmt += price;
		}
		String msg = Arrays.toString(items)+" with prices "+Arrays.toString(prices)+" are purchased with Bill Amount : "+billAmt;
		String status = sendMail(msg, toEmails);
		return msg+"-->"+status;
	}
	
	private String sendMail(String msg, String[] toEmails) throws Exception{
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Open it know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("nit.gif", new ClassPathResource("nit.gif"));
		sender.send(message);
		return "Mail sent.";
	}

}
