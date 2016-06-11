package com.haurylenka.projects.rest.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResComponent")
public class ResComponent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String componentTypeCode;
	private String createDateTime;
	private String internalStatus;
	private int sequence;
	
	@XmlAttribute
	public String getComponentTypeCode() {
		return componentTypeCode;
	}
	
	public void setComponentTypeCode(String componentTypeCode) {
		this.componentTypeCode = componentTypeCode;
	}
	
	@XmlAttribute
	public String getCreateDateTime() {
		return createDateTime;
	}
	
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	
	@XmlAttribute
	public String getInternalStatus() {
		return internalStatus;
	}
	
	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}
	
	@XmlAttribute
	public int getSequence() {
		return sequence;
	}
	
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}