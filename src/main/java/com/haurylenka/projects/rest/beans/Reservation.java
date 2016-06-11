package com.haurylenka.projects.rest.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String description;
	private List<ResComponent> components;
	private List<Customer> customers;
	private FareFamily fareFamily;
	
	@XmlAttribute()
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@XmlAttribute()
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElementRef
	public List<ResComponent> getComponents() {
		return components;
	}
	
	public void setComponents(List<ResComponent> components) {
		this.components = components;
	}

	@XmlElementRef
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@XmlElement(name = "FareFamily")
	public FareFamily getFareFamily() {
		return fareFamily;
	}

	public void setFareFamily(FareFamily fareFamily) {
		this.fareFamily = fareFamily;
	}
	
}