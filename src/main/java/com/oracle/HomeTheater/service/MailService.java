package com.oracle.HomeTheater.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.oracle.HomeTheater.domain.MailDTO;

@Component
@Slf4j
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(MailDTO mail) {
		log.info("CH_MailService sendMail Start...");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mail.getAddress());
		message.setSubject(mail.getTitle());
		message.setText(mail.getMessage());
		
		mailSender.send(message);
	}

}
