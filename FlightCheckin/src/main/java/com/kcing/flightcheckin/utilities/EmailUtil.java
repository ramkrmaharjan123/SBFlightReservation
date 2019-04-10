package com.kcing.flightcheckin.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void emailIternary(String sendTo,String filePath) {
		
		MimeMessage message =javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper hp = new MimeMessageHelper(message,true);
			hp.setTo(sendTo);
			hp.setSubject("Itinerary for your travel");
			hp.setText("Please check your itenerary in the attachment");
			hp.addAttachment("Iternary", new File(filePath));
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
