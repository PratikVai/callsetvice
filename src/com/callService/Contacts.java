package com.callService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Contact")
public class Contacts {

	private int contactID;
	private String contactName;
	private String connectionType;
	private String country;
	private String number;
	private String alternateNo;
	
	public Contacts(){}
	
	public Contacts(int contactID, String contactName, String connectionType, String country, String number,String alternateNo) {
		
		this.contactID = contactID;
		this.contactName = contactName;
		this.connectionType = connectionType;
		this.country = country;
		this.number = number;
		this.alternateNo = alternateNo;
	}

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAlternateNo() {
		return alternateNo;
	}

	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}
	
	
	
	
}
