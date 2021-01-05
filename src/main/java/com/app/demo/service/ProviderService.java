package com.app.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Provider;
import com.app.demo.pojos.Services;
import com.app.demo.pojos.SubServices;
import com.app.demo.repository.ProviderRepository;
import com.app.demo.repository.ServiceRepository;
import com.app.demo.repository.SubServiceRepository;

@Service
public class ProviderService {

	@Autowired
	private AddressService addrService;

	
	@Autowired
	private ServiceRepository serviceRepo;
	
	@Autowired
	private ProviderRepository providerRepo;
	
	@Autowired
	private SubServiceRepository subServiceRepo ;
	
	
	public Provider login(String mobile, String password) {
		return providerRepo.findByMobileAndPassword(mobile,password);
	}
	
	
	public void addProvider(Provider provider) {
		Address address = provider.getAddress();
		address.setPid(provider);
		Services service = serviceRepo.findBySname(provider.getPservice().getSname()); 
		provider.setPservice(service);
		//System.out.println(service.getSname());
		
		providerRepo.save(provider);
		addrService.saveAddr(address);
		
		
		
	}


	public List<Provider> getAllProviders() {
		List<Provider> providers = new ArrayList<>();
		providerRepo.findAll().forEach(providers::add);
		return providers;
	}


	public List<Provider> getProvidersOfService(String subService) {
		Services service = subServiceRepo.findBySubservicename(subService).getServices();
		//System.out.println(subServices.getSubservicename());
		//Services service = subServices.getServices();
		System.out.println(service.getSname());
		List<Provider> providers = new ArrayList<>();
		providerRepo.findAllByPservice(service).forEach(providers::add);
		return providers;
		
	}


	public Provider getPro(Integer id) {
		// TODO Auto-generated method stub
		return providerRepo.getOne(id);
	}


	
}
