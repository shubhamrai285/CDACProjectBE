package com.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.*;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(String email ,String fname) throws  MailException
	{
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setFrom("shubhamrai285@gmail.com");
		mailMessage.setSubject("Household service");
		mailMessage.setText("Hello "+fname+" You have successfully Registered with HouseHold Services");
		javaMailSender.send(mailMessage);
	}
	
	public void sendNotificationToCustomer(String email ,String fname) throws  MailException
	{
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setFrom("shubhamrai285@gmail.com");
		mailMessage.setSubject("Household service");
		mailMessage.setText("Hello "+fname+"  Your Service has been send to Service Provider");
		javaMailSender.send(mailMessage);
	}
	
	public void sendNotificationToProvider(String email ,String fname) throws  MailException
	{
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setFrom("shubhamrai285@gmail.com");
		mailMessage.setSubject("Household service");
		mailMessage.setText("Hello "+fname+"you have new service request please login to check");
		javaMailSender.send(mailMessage);
	}

	public void sendNotificationForPassword(String email, String fname, String password) {
		

		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setFrom("shubhamrai285@gmail.com");
		mailMessage.setSubject("Household service");
		mailMessage.setText("Hello "+fname+"your password is: "+password);
		javaMailSender.send(mailMessage);
	}
	
}
