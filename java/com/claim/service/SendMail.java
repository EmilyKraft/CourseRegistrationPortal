package com.claim.service;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.claim.constant.InvoiceTemplate;

@Service
public class SendMail {

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail(String toEmail, String subject, String message){

		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(toEmail);
		email.setSubject(subject);
		email.setText(message);

		emailSender.send(email);
	}

	public void sendInvoice(String toEmail, String subject, String emailMessage){
		try { 
			MimeMessage message = emailSender.createMimeMessage();

			message.setSubject("Subject");

			MimeMessageHelper helper;

			helper = new MimeMessageHelper(message, true);

			helper.setSentDate(new Date());

			helper.setTo(toEmail);

			helper.setText(emailMessage, true);

			emailSender.send(message);
		} catch (Exception e){

		}

	}
}
