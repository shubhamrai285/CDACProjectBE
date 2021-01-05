package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.SubServices;

@Repository
public interface SubServiceRepository extends JpaRepository<SubServices,Integer> {

	SubServices findBySubservicename(String subService);

}
