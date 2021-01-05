package com.app.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="SubServices")
@JsonInclude(Include.NON_NULL)
public class SubServices {
private Integer id;
private String subservicename;
private double price;
private byte [] images;
@JsonBackReference
private Services services ;

public SubServices() {
	super();
	// TODO Auto-generated constructor stub
}
public SubServices(String subservicename, double price) {
	super();
	this.subservicename = subservicename;
	this.price = price;
	
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "sb_id")
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}


public String getSubservicename() {
	return subservicename;
}
public void setSubservicename(String subservicename) {
	this.subservicename = subservicename;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


@Lob
public byte[] getImages() {
	return images;
}
public void setImages(byte[] images) {
	this.images = images;
}
@ManyToOne
@JoinColumn(name="s_id")
public Services getServices() {
	return services;
}
public void setServices(Services services) {
	this.services = services;
}
@Override
public String toString() {
	return "SubServices [id=" + id + ", subservicename=" + subservicename + ", price=" + price + ", services="
			+ services + "]";
}


}
