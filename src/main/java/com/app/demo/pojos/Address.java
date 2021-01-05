package com.app.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Address")
@JsonInclude(Include.NON_NULL)
public class Address 
{
	private Integer id;
	private int pincode;
	private String city;
	private String locality;
	private String state ;
	@JsonIgnore
	@JsonManagedReference(value="cid")
	private Customer cid;
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Provider pid ;
	public Address() {
	}
	public Address( int pincode, String city, String locality, String state) {
		
		this.pincode = pincode;
		this.city = city;
		this.locality = locality;
		this.state = state;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	//@Range(max = 6,min = 6)
	@Column(name = "pincode")
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "locality")
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	@OneToOne
	@JoinColumn(name="c_id")
	public Customer getCid() {
		return cid;
	}
	public void setCid(Customer cid) {
		this.cid = cid;
	}
	

	@OneToOne()
	@JoinColumn(name="p_id")
	@JsonIgnore
	 @JsonManagedReference(value="pid")
	public Provider getPid() {
		return pid;
	}
	public void setPid(Provider pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", pincode=" + pincode + ", city=" + city + ", locality=" + locality + ", state="
				+ state + "]";
	}
	

}
