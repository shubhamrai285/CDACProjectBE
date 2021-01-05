package com.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Services;
import com.app.demo.pojos.SubServices;
import com.app.demo.repository.ServiceRepository;
import com.app.demo.repository.SubServiceRepository;

@Service
public class SubFacilityService {
	

	
	
	@Autowired
	private SubServiceRepository subServiceRepo;
	
	@Autowired
	private ServiceRepository serviceRepo;
	
	public void addSubService(String serviceName, String subServiceName) {
		Services service = new Services();
		SubServices subService = new SubServices();
		service = serviceRepo.findBySname(serviceName);
		System.out.println(service.getId());
		subService.setSubservicename(subServiceName);
		subService.setServices(service);
		
		subServiceRepo.save(subService);	
	}

	public List<SubServices> getAllSubServices(String serviceName) {
		return  serviceRepo.findBySname(serviceName).getSubservices();
		
	}

	public double setPrice(String subServiceName, double price) {
		SubServices subService = subServiceRepo.findBySubservicename(subServiceName);
		subService.setPrice(price);
		return price;
	}
	
	
	
}
