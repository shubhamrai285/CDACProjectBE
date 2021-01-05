package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.Provider;
import com.app.demo.pojos.Services;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

	Provider findByMobileAndPassword(String mobile, String password);

	Iterable<Provider> findAllByPservice(Services service);

	//Iterable<Provider> findAllByPservice();

}
