package com.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Services;
import com.app.demo.repository.ServiceRepository;

@Service
public class FacilityService {

	@Autowired
	private ServiceRepository serviceRepo ;
	
	
	public void addService(Services service) {
		serviceRepo.save(service);
	}


	public Services getService(String sname) {
		return serviceRepo.findBySname(sname);
		
	}


	public List<Services> getAllServices() {
		return serviceRepo.findAll();
		
	}
}
