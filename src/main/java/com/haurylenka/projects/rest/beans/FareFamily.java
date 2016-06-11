package com.haurylenka.projects.rest.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FareFamily")
public class FareFamily implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fareFamilyCode;
	private List<AncillaryAirComponent> components;
	
	@XmlAttribute
	public String getFareFamilyCode() {
		return fareFamilyCode;
	}
	
	public void setFareFamilyCode(String fareFamilyCode) {
		this.fareFamilyCode = fareFamilyCode;
	}
	
	@XmlElementRef
	public List<AncillaryAirComponent> getComponents() {
		return components;
	}
	
	public void setComponents(List<AncillaryAirComponent> components) {
		this.components = components;
	}
	
}