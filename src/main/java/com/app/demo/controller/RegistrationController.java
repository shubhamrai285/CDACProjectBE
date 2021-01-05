package com.app.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.service.NotificationService;



@RestController
public class RegistrationController {

	
	private Logger logger=LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
	private NotificationService notifiy;
	

	@RequestMapping("signupSuccesss")
	public String Signupsuccess()
	{
//		try
//		{
//		notifiy.sendNotification();
//		}
//		catch(MailException e)
//		{
//			logger.info("Error sending email"+e.getMessage());
//			
//		}
		
		return "Thanku for registration";
	}
}
