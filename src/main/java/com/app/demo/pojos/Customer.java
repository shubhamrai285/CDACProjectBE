package com.app.demo.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="Customer")
@JsonInclude(Include.NON_NULL)
public class Customer
{
	private Integer id;
	private String fname;
	private String lname;
	private String mobile;
	private String email ;
	private String password;
	@JsonBackReference
	private Address address;
	
	@Transient
	private Set <CustomerProvider> custProvider = new HashSet<>();;
	
	
	

	public Customer() {
	}
	
	
	
	public Customer(Integer id) {
		super();
		this.id = id;
	}



	public Customer( String fname, String lname, String mobile,String email , String password,Address address) {
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.email = email ;
		this.password = password;
		this.address = address;
	
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne(cascade =CascadeType.ALL,mappedBy="cid")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.LAZY,  orphanRemoval = true)
	public Set<CustomerProvider> getCustProvider() {
		return custProvider;
	}

	public void setCustProvider(Set<CustomerProvider> custProvider) {
		this.custProvider = custProvider;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", mobile=" + mobile + ", email="
				+ email + ", password=" + password + ", address=" + address + "]";
	}



	
	
	
}
