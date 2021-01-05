package com.app.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Customer;
import com.app.demo.service.AddressService;
import com.app.demo.service.CustomerService;
import com.app.demo.service.NotificationService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private AddressService addrService ;
	
	private Logger logger=LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
	private NotificationService notifiy;

	@RequestMapping("login/{mobile}/{password}")
	public ResponseEntity<?> login(@PathVariable String mobile,@PathVariable String password)
	{
		             Customer login = service.login(mobile,password);
		if (login == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Customer>(login, HttpStatus.OK);
	}
	
	@RequestMapping("login")
	public String getCustomer() {
		return "Shubham Phalke";
	}
	
	@RequestMapping("c/{id}")
	public Optional<Customer>findCust(@PathVariable Integer id){
		return service.findCust(id);
	}
	@PostMapping("getpassword")
	public ResponseEntity<?> findCustByEmail(@RequestBody Map<String,String>  email1)
	{
		String email2=email1.get("email");
		System.out.println(email2);
		Customer cust = service.findCustByEmail(email2);
		if (cust == null)
			return new ResponseEntity<String>("Not yet registered",HttpStatus.NO_CONTENT);
		
		
		try
		{
		notifiy.sendNotificationForPassword(cust.getEmail(),cust.getFname(),cust.getPassword());
		}
		catch(MailException e)
		{
			logger.info("Error sending email"+e.getMessage());
			
		}
		return  new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping("cad/{id}")
	public List<Address> findCustAddr(@PathVariable Integer id){
		return addrService.findByCustId(id);
	}
	
	@RequestMapping("cpin/{id}")
	public String findCustPin(@PathVariable Integer id){
		return addrService.findCustsPincode(id);
	}
	@RequestMapping("customers/{id}")
	public Customer getCust(@PathVariable Integer id) {
		System.out.println(service.getCust(id));
		return service.getCust(id);
	}
	
	@RequestMapping("custs")
	public List<Customer> getAllCusts(){
		return service.getAllCustomers();
		
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/cust")
	public void addCust(@RequestBody Customer cust ) {
		Address addr = cust.getAddress();
		addr.setCid(cust);
		cust.setAddress(addr);
		System.out.println(addr.getCity());
		System.out.println(addr.getCid());
		
		try
		{
		notifiy.sendNotification(cust.getEmail(),cust.getFname());
		}
		catch(MailException e)
		{
			logger.info("Error sending email"+e.getMessage());
			
		}
		
		
		service.addCust(cust);
		addrService.saveAddr(addr);
	}
	
	@PutMapping("cust/update/{id}")
	public void updateAddress(@PathVariable(value = "id") Integer id,@RequestBody Address address ) {
		addrService.updateAddress( id,  address);
	}
	
	
	
	
	
}
