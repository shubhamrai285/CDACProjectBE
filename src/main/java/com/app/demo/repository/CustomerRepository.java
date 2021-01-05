package com.app.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	Customer findByMobileAndPassword(String mobile,String password);

	Customer findByEmail(String email);
}
