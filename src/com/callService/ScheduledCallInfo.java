package com.callService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ScheduledCall")
public class ScheduledCallInfo {

	/**
	 * 
	 */
	
	private int callId;
	private String employeeName;
	private String myExtentionNo;
	private String externalNo;
	private String myDesk;
	private String name;
	private String connectionType;
	private String country;
	private String number;
	private String alternateNumber;
	private String date;
	private String time;
	private String status;
	
	
	public ScheduledCallInfo() {}
	
	public ScheduledCallInfo(String name, String connectionType, String country, String number, String alternateNumber, String date, String time) {
		
		this.name = name;
		this.connectionType = connectionType;
		this.country = country;
		this.number = number;
		this.alternateNumber = alternateNumber;
		this.date = date;
		this.time = time;
	}
	
	
	public int getCallId() {
		return callId;
	}

	public void setCallId(int callId) {
		this.callId = callId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMyExtentionNo() {
		return myExtentionNo;
	}

	public void setMyExtentionNo(String myExtentionNo) {
		this.myExtentionNo = myExtentionNo;
	}

	public String getExternalNo() {
		return externalNo;
	}

	public void setExternalNo(String externalNo) {
		this.externalNo = externalNo;
	}

	public String getMyDesk() {
		return myDesk;
	}

	public void setMyDesk(String myDesk) {
		this.myDesk = myDesk;
	}

		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
