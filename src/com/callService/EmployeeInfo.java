package com.callService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Employee")

public class EmployeeInfo {
		
	private int id;
	private String name, desk;
	private int phoneNo, alternateNo;
	
	
	public EmployeeInfo() {	}
		
	
	public EmployeeInfo(int id, String name, String desk, int phoneNo, int alternateNo) {
		
		this.id = id;
		this.name = name;
		this.desk = desk;
		this.phoneNo = phoneNo;
		this.alternateNo = alternateNo;
	}


	public int getId() {
		return id;
	}
	//@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	//@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDesk() {
		return desk;
	}
	//@XmlElement
	public void setDesk(String desk) {
		this.desk = desk;
	}
	
	
	public int getPhoneNo() {
		return phoneNo;
	}
	//@XmlElement
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	public int getAlternateNo() {
		return alternateNo;
	}
	//@XmlElement
	public void setAlternateNo(int alternateNo) {
		this.alternateNo = alternateNo;
	}
	
	

}
