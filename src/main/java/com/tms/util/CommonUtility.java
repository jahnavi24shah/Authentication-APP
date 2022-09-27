package com.tms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class CommonUtility {
	
	@Value("${mailHeader}")
	private String mailHeader;
	
	@Value("${mailFooter}")
	private String mailFooter;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String rname,String email,String subject,String message) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        mailHeader="Hi "+rname+",\n\n";
//        String finalMessage = mailHeader+message+mailFooter;
//        msg.setTo(email);
//        msg.setSubject(subject);
//        msg.setText(finalMessage);
//        javaMailSender.send(msg);
    }
}