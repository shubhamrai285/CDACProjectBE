package com.app.demo.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Services")
@JsonInclude(Include.NON_NULL)
public class Services {
	private Integer id;
	private String sname;
	@JsonIgnore
	@JsonManagedReference(value = "subservices")
	private List<SubServices> subservices;
	@JsonIgnore
	@JsonManagedReference(value = "providers")
	private List<Provider> providers;

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Services(String sname) {

		this.sname = sname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "services")
	@JsonManagedReference(value = "subservices")
	public List<SubServices> getSubservices() {
		return subservices;
	}

	public void setSubservices(List<SubServices> subservices) {
		this.subservices = subservices;
	}


	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pservice")
	@JsonManagedReference(value = "providers")
	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "Services [id=" + id + ", sname=" + sname + "]";
	}

}
