package com.app.demo.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Customer;
import com.app.demo.repository.AddressRepository;
import com.app.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custRepo;
	
	public Customer login(String mobile,String password) {
		
		return custRepo.findByMobileAndPassword(mobile,password);
	}
	

	public Optional<Customer> findCust(Integer id) {
		return custRepo.findById(id);
	}
	
	
	public Customer getCust(Integer id) {
		return custRepo.getOne(id);
	}
	
	
	public List<Customer> getAllCustomers(){
		List<Customer> custs = new ArrayList<>();
		custRepo.findAll().forEach(custs::add);
		return custs;
		
	}
	
	public void addCust(Customer cust) {
		
		custRepo.save(cust);
	}


	public Customer findCustByEmail(String email) {
		
		return custRepo.findByEmail(email);
	}


	
	
}
