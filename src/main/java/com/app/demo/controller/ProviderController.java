package com.app.demo.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Provider;
import com.app.demo.pojos.Services;
import com.app.demo.repository.ProviderRepository;
import com.app.demo.service.AddressService;
import com.app.demo.service.FacilityService;
import com.app.demo.service.NotificationService;
import com.app.demo.service.ProviderService;


@CrossOrigin
@RestController
public class ProviderController {

	@Autowired
	private ProviderService proService;
	
	@Autowired
	private AddressService addrService ;
	
	@Autowired 
	private  FacilityService fservice;

	@Autowired
	private ProviderRepository providerRepo;
	
	

	private Logger logger=LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
	private NotificationService notifiy;
	
	
	@RequestMapping("providers")
	public List<Provider> getAllProviders(){
		return proService.getAllProviders();
	}
	
	@RequestMapping("cart/{id}")
	public Provider getPro(@PathVariable Integer id) {
		//System.out.println(proService.getPro(id));
		return proService.getPro(id);
	}
	
	@RequestMapping("provider/login/{mobile}/{password}")
	public ResponseEntity<?> login(@PathVariable String mobile,@PathVariable String password)
	{
		     Provider login = proService.login(mobile,password);
		if (login == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Provider>(login, HttpStatus.OK);
	}
	
//	@RequestMapping(method=RequestMethod.POST , value="/provider")
//	public void addProvider1(@RequestBody Provider provider ) {
//		proService.addProvider(provider);
//	}
	
	@PostMapping("provider")
	public void addProvider(
			@RequestParam(value="fname") String fname,
			@RequestParam(value="lname") String lname,
			@RequestParam(value="mobile") String mobile,
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			@RequestParam(value="pincode") int pincode,
			@RequestParam(value="city") String city,
			@RequestParam(value="locality") String locality,
			@RequestParam(value="state") String state,
			@RequestParam(value="servicename") String servicename,
			@RequestParam(value="image") MultipartFile image
	
			){
		//proService.addProvider(provider);
		Address address=new Address(pincode,city,locality,state);
		
		Provider provider= new Provider(fname,lname,mobile,email,password,address);
	    address.setPid(provider);
	            Services service = fservice.getService(servicename);
	            System.out.println(service);
	            provider.setPservice(service);
	        
	    
	    try {
			provider.setImages(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    

		try
		{
		notifiy.sendNotification(provider.getEmail(),provider.getFname());
		}
		catch(MailException e)
		{
			logger.info("Error sending email"+e.getMessage());
			
		}
	    
		providerRepo.save(provider);
		addrService.saveAddr(address);
	}

	
	@RequestMapping("subServices/{subService}")
	public List<Provider> getProvidersOfService(@PathVariable String subService){
		
		return proService.getProvidersOfService(subService);
	}

	
	@PutMapping("provider/update/{id}")
	public void updateAddress(@PathVariable(value = "id") Integer id,@RequestBody Address address ) {
		addrService.updateProviderAddress(id, address);
	}
	
	
	
	
}
