package com.app.demo.pojos;



import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CustomerProvider {
	
	@EmbeddedId
	CustomerProviderKey id ;
	
	@ManyToOne//(fetch = FetchType.EAGER)
	@MapsId("cust_id")
	@JoinColumn(name="cust_id")
	Customer customer;
	
	@ManyToOne//(fetch = FetchType.EAGER)
	@MapsId("provider_id")
	@JoinColumn(name="provider_id")
	Provider provider;
	
	@Basic
	@JoinColumn(name="date")
	@JsonFormat(pattern ="yyyy-MM-dd")
	private LocalDate date ;
	
	public CustomerProvider() {
		// TODO Auto-generated constructor stub
	}

	public CustomerProvider(CustomerProviderKey id, Customer customer, Provider provider, LocalDate date) {
		super();
		this.id = id;
		this.customer = customer;
		this.provider = provider;
		this.date = date;
	}

	
	public CustomerProvider(CustomerProviderKey id, LocalDate date) {
		super();
		this.id = id;
		this.date = date;
	}

	public CustomerProvider(LocalDate date2) {
		// TODO Auto-generated constructor stub
		this.date = date2;
	}

	public CustomerProviderKey getId() {
		return id;
	}

	public void setId(CustomerProviderKey id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CustomerProvider [id=" + id + ", customer=" + customer + ", provider=" + provider + ", date=" + date
				+ "]";
	}

	

	

	
	
	
	
	
	

}
