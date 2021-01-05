package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Integer>{

	Services findBySname(String sname);

	
}
