package com.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Customer;
import com.app.demo.pojos.Provider;
import com.app.demo.repository.AddressRepository;
import com.app.demo.repository.CustomerRepository;
import com.app.demo.repository.ProviderRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo ;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private ProviderRepository providerRepo;
	
    public void saveAddr(Address add) {
		
		addressRepo.save(add);
	}

	public List<Address> findByCustId(Integer id) {
		
		return addressRepo.findByCid(id);
	}
	
	public String findCustsPincode(Integer id) {
		return addressRepo.findPinByCid(id);
	}
	
	public void updateAddress(Integer id, Address address) {
		Customer customer = custRepo.getOne(id);
		Integer aid = addressRepo.findAidByCid(id);
		address.setId(aid);
		address.setCid(customer);
		customer.setAddress(address);
		custRepo.save(customer);		
		
	}
	
	public void updateProviderAddress(Integer id, Address address) {
		Provider provider = providerRepo.getOne(id);
		Integer aid = addressRepo.findAidByCid(id);
		address.setId(aid);
		address.setPid(provider);
		provider.setAddress(address);
		providerRepo.save(provider);		
		
	}
	
}
