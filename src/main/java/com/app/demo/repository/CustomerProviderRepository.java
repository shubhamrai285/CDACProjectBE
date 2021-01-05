package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.CustomerProvider;
import com.app.demo.pojos.CustomerProviderKey;
import com.app.demo.pojos.Provider;

@Repository
public interface CustomerProviderRepository extends JpaRepository<CustomerProvider,CustomerProviderKey> {

	CustomerProvider findByProvider(Provider pro);

	Iterable<CustomerProvider> findAllByProvider(Provider pro);
}
