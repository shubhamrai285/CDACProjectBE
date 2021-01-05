package com.app.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Customer;
import com.app.demo.pojos.CustomerProvider;
import com.app.demo.pojos.CustomerProviderKey;
import com.app.demo.pojos.ProCustomers;
import com.app.demo.pojos.Provider;
import com.app.demo.service.CustProService;
import com.app.demo.service.NotificationService;

@RestController
@CrossOrigin
public class CustProController {
	
	@Autowired
	private CustProService custProService;
	
	@Autowired
	private CustomerController custController;
	
	@Autowired
	private ProviderController proController ;

	

	private Logger logger=LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
	private NotificationService notifiy;
	
	
	
	@GetMapping("getall/{custId}/{proId}/{date}")
	public ResponseEntity<?>  getCustProDetails(@PathVariable Integer custId,@PathVariable Integer proId,@PathVariable String date ) {
	
		LocalDate date1=LocalDate.parse(date);
		CustomerProvider custPro = new CustomerProvider(date1);
		System.out.println("in  payment");
		if(custController.getCust(custId) == null && proController.getPro(proId)== null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		Customer cust = custController.getCust(custId);
		Provider pro = proController.getPro(proId);
		
		
		CustomerProviderKey custProKey = new CustomerProviderKey(custId,proId);
		custPro.setId(custProKey);
		
		CustomerProvider customerProvider = custProService.setCustPro(custPro);

		try
		{
		notifiy.sendNotificationToCustomer(cust.getEmail(),cust.getFname());
		}
		catch(MailException e)
		{
			logger.info("Error sending email"+e.getMessage());
			
		}
		
		
		try
		{
		notifiy.sendNotificationToProvider(pro.getEmail(),pro.getFname());
		}
		catch(MailException e)
		{
			logger.info("Error sending email"+e.getMessage());
			
		}
		
		
		
		return new ResponseEntity<CustomerProvider>(customerProvider, HttpStatus.OK);
		
	}
	
	@GetMapping("allCusts/{proId}")
	public List<Address> getAllCustsOfPro(@PathVariable Integer proId){
		Provider pro = proController.getPro(proId);
		//List<Customer> custs = custProService.getAllCustsOfPro(pro);
		System.out.println(pro.getFname());
		
		return custProService.getAllCustsOfPro(pro);
	}
	
	@GetMapping("allCustsDate/{proId}")
	public List<ProCustomers> getAllCusts(@PathVariable Integer proId){
		Provider pro = proController.getPro(proId);
		//List<Customer> custs = custProService.getAllCustsOfPro(pro);
		System.out.println(pro.getFname());
		
		return custProService.getAllCust(pro);
	}
	
	@GetMapping("allCustsBySet/{proId}")
	public Set<CustomerProvider> getAllCustsOfProSet(@PathVariable Integer proId){
		Provider pro = proController.getPro(proId);
		//List<Customer> custs = custProService.getAllCustsOfPro(pro);
		//System.out.println(pro.getFname());
		
		return pro.getCustProvider();
	}
	
	@GetMapping("allCustAdd/{proId}")
	public List<Object> getCustsList(@PathVariable Integer proId){
		Provider pro = proController.getPro(proId);
		
		Set<CustomerProvider> custPro = pro.getCustProvider();
		//return pro.getCustProvider();
		return null ;
	}
	
	
}
