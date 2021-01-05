package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.CustomerProvider;
import com.app.demo.pojos.Provider;


public interface CustProRepository extends JpaRepository<CustomerProvider, Integer> {

	void findByProvider(Provider pro);

}
