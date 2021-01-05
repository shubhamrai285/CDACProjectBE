package com.app.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Customer;
import com.app.demo.pojos.CustomerProvider;
import com.app.demo.pojos.ProCustomers;
import com.app.demo.pojos.Provider;
import com.app.demo.repository.CustomerProviderRepository;

@Service
public class CustProService {
	
	//@Autowired
	//private CustProRepository custProRepo;

	@Autowired
	private CustomerProviderRepository custProRepo;
	
	public CustomerProvider setCustPro(CustomerProvider custPro) {
		
		
		return custProRepo.save(custPro);
	}

	public List<Address> getAllCustsOfPro(Provider pro) {
		
		
		
		List<CustomerProvider> custPro = new ArrayList<>(); 
		List<Customer> custs = new ArrayList<>(); 
				custProRepo.findAllByProvider(pro).forEach(custPro :: add);
				for(CustomerProvider c : custPro) {
					System.out.println(c.getCustomer());
					custs.add(c.getCustomer());
					}
				List<Address> custAdd = new ArrayList<>();
				for(Customer c : custs) {
					System.out.println(c.getAddress());
					custAdd.add(c.getAddress());
				}
				
				return custAdd;
	}
	
public List<ProCustomers> getAllCust(Provider pro) {
		List<CustomerProvider> custPro = new ArrayList<>(); 
		List<ProCustomers> custs = new ArrayList<>();
		ProCustomers proCust ;
		 
				custProRepo.findAllByProvider(pro).forEach(custPro :: add);
				for(CustomerProvider c : custPro) {
					proCust = new ProCustomers(c.getDate(),c.getCustomer(),c.getCustomer().getAddress());
					custs.add(proCust);
					}
				
				
				return custs;
	}

}
