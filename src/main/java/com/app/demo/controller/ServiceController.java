package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Services;
import com.app.demo.service.FacilityService;
@CrossOrigin
@RestController
public class ServiceController {

	@Autowired
	private FacilityService facility;
	
	@RequestMapping(method=RequestMethod.POST , value="/service")
	public String addService(@RequestBody Services ser) {
		facility.addService(ser);
		return "Hello";
	}
	
	@GetMapping("/service/{name}")
	public Services getService(@PathVariable("name") String sname) {
		return facility.getService(sname);
	}
	
	@GetMapping("/services")
	public List<Services> getAllServices() {
		return facility.getAllServices();
	}
	
	
}
