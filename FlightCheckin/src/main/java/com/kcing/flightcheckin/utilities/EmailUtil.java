package com.kcing.flightcheckin.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Value("${com.kcing.flightcheckin.email.body}")
	private String EMAIL_BODY ;
	@Value("${com.kcing.flightcheckin.email.subject}")
	private String EMAIL_SUBJECT;
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void emailIternary(String sendTo,String filePath) {
		
		MimeMessage message =javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper hp = new MimeMessageHelper(message,true);
			hp.setTo(sendTo);
			hp.setSubject(EMAIL_SUBJECT);
			hp.setText(EMAIL_BODY);
			hp.addAttachment("Iternary", new File(filePath));
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
