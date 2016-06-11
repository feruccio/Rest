package com.haurylenka.projects.rest.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	private String amountPaid;
	private String formOfPaymentTypeCode;
	private String currencyCode;
	
	@XmlAttribute
	public String getAmountPaid() {
		return amountPaid;
	}
	
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	@XmlAttribute
	public String getFormOfPaymentTypeCode() {
		return formOfPaymentTypeCode;
	}
	
	public void setFormOfPaymentTypeCode(String formOfPaymentTypeCode) {
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
	}
	
	@XmlAttribute
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}