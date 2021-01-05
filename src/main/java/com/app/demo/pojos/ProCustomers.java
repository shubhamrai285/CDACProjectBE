package com.app.demo.pojos;

import java.time.LocalDate;

public class ProCustomers {
	private LocalDate date;
	private Customer cust ;
	private Address addr ;
	
	public ProCustomers() {
		// TODO Auto-generated constructor stub
	}

	public ProCustomers(LocalDate date, Customer cust, Address addr) {
		super();
		this.date = date;
		this.cust = cust;
		this.addr = addr;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "ProCustomers [date=" + date + ", cust=" + cust + ", addr=" + addr + "]";
	}
	
	
}
