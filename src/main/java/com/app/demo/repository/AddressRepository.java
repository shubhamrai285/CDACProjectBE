package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

	@Query(
			  value = "SELECT * FROM address a WHERE a.c_id =:cid", 
			  nativeQuery = true)
	List<Address> findByCid(@Param("cid")int id);
	
	@Query(
			  value = "SELECT pincode FROM address a WHERE a.c_id =:cid", 
			  nativeQuery = true)
	String findPinByCid(@Param("cid")int id);
	
	@Query(
			  value = "SELECT a_id FROM address a WHERE a.c_id =:cid", 
			  nativeQuery = true)
	Integer findAidByCid(@Param("cid")int id);
}
