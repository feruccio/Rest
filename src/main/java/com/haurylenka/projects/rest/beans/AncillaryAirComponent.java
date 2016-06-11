package com.haurylenka.projects.rest.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AncillaryAirComponent")
public class AncillaryAirComponent implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ancillaryAirComponentCode;

	@XmlAttribute
	public String getAncillaryAirComponentCode() {
		return ancillaryAirComponentCode;
	}

	public void setAncillaryAirComponentCode(String ancillaryAirComponentCode) {
		this.ancillaryAirComponentCode = ancillaryAirComponentCode;
	}
	
}