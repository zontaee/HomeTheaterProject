package com.oracle.HomeTheater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.oracle.HomeTheater.domain.MailDTO;

@Component
public class CH_MailService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(MailDTO mail) {
		System.out.println("CH_MailService sendMail Start...");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mail.getAddress());
		message.setSubject(mail.getTitle());
		message.setText(mail.getMessage());

		mailSender.send(message);
	}

}