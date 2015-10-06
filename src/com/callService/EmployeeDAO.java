package com.callService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
	
	Connection con = null;
	
	public EmployeeDAO() {
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			System.out.println("not found JDBC");
			e.printStackTrace();
		}
	}
	
	public void connect(){
		try {
			
			con= DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db_Buzz.db");
			System.out.println("database Opened succesfully");
			
		} catch (SQLException e) {
			System.out.println("not connected to database");
			e.printStackTrace();
		}
	}
	
	public List<EmployeeInfo> getAllEmployees(){
		
		Statement statement = null;
		ResultSet resultset = null;
		List<EmployeeInfo> employeeList = new ArrayList<EmployeeInfo>() ;
		
		try {
			connect();			
			statement= con.createStatement();
			resultset= statement.executeQuery("SELECT * FROM EmployeeData");
			
			while(resultset.next())
			{
				int id=resultset.getInt("id");
				String name= resultset.getString("name");
				
				EmployeeInfo employee = new EmployeeInfo();
				employee.setId(id);
				employee.setName(name);
				employeeList.add(employee);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not found Employees");
		}
		finally
		{
			try {
				resultset.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("not closed connection");
			}
		}			
		
		System.out.println("operation done succesfully.");
		return employeeList;
		
	}
	
	

	public void addEmployeeInfo(String empName , String desk ) {
		Statement statement = null;
		//ResultSet resultset = null;
		//List<EmployeeInfo> employeeList = new ArrayList<EmployeeInfo>() ;
		
		try {
			connect();			
			statement= con.createStatement();
			statement.executeQuery("INSERT INTO EmployeeData(NAME,DESK) VALUES('"+empName+"','"+desk+"');");
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not inserted Employees");
		}
		finally
		{
			try {
				//resultset.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("not closed connection");
			}
		}
		System.out.println("insertion done succesfully.");
		
		
		
	}
	
	
	public void scheduleCall(String employeeName, String myExtentionNo, String externalNo, String myDesk, String name, String connectionType, String country, String number, String alternateNumber,String addToContacts, String date, String time){
		Statement statement = null;
		
		
		try {
			connect();
			statement= con.createStatement();
			if(addToContacts!=null)
			{
				statement.executeUpdate("INSERT INTO Contacts(CONTACTNAME,CONNECTIONTYPE,COUNTRY,NUMBER,ALTERNATENUMBER) VALUES ('"+name+"','"+connectionType+"','"+country+"','"+number+"','"+alternateNumber+"');");
			}else
			{
				System.out.println("not inserted into contacts");
			}
			
			statement.executeUpdate("INSERT INTO ScheduledCalls (EMPLOYEENAME,MYEXTENTIONNO,EXTERNALNO,MYDESK,NAME,CONNECTIONTYPE,COUNTRY,NUMBER,ALTERNATENUMBER,DATE,TIME,STATUS) VALUES ('"+employeeName+"','"+myExtentionNo+"','"+externalNo+"','"+myDesk+"','"+name+"','"+connectionType+"','"+country+"','"+number+"','"+alternateNumber+"','"+date+"','"+time+"','P');");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally{
			try {
				//resultset.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("not closed connection");
			}
		}
		
	}
	
	
	public List<ScheduledCallInfo> getScheduledCalls(){
		
		Statement statement = null;
		ResultSet resultset = null;
		List<ScheduledCallInfo> scheduledCallInfo = new ArrayList<ScheduledCallInfo>() ;
		
		try {
			connect();			
			statement= con.createStatement();
			resultset= statement.executeQuery("SELECT * FROM ScheduledCalls WHERE status='P';");
			
			while(resultset.next())
			{
				int callId=resultset.getInt("callId");
				String myExtentionNo =resultset.getString("myExtentionNo");
				String name= resultset.getString("name");
				String country= resultset.getString("country");
				String number= resultset.getString("number");
				String date= resultset.getString("date");
				String time= resultset.getString("time");
				
				ScheduledCallInfo scheduledCall = new ScheduledCallInfo();
				
				scheduledCall.setCallId(callId);
				scheduledCall.setMyExtentionNo(myExtentionNo);
				scheduledCall.setName(name);
				scheduledCall.setCountry(country);
				scheduledCall.setNumber(number);
				scheduledCall.setDate(date);
				scheduledCall.setTime(time);
				
				scheduledCallInfo.add(scheduledCall);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not found calls");
		}
		finally
		{
			try {
				resultset.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("not closed connection");
			}
		}			
		
		System.out.println("operation done succesfully.");
		return scheduledCallInfo;
		
	}
	
	public List<ScheduledCallInfo> getCallHistory(){
		
		Statement statement = null;
		ResultSet resultset = null;
		List<ScheduledCallInfo> scheduledCallInfo = new ArrayList<ScheduledCallInfo>() ;
		
		try {
			connect();			
			statement= con.createStatement();
			resultset= statement.executeQuery("SELECT * FROM ScheduledCalls WHERE status='C';");
			
			while(resultset.next())
			{
				int callId=resultset.getInt("callId");
				String myExtentionNo =resultset.getString("myExtentionNo");
				String name= resultset.getString("name");
				String country= resultset.getString("country");
				String number= resultset.getString("number");
				String date= resultset.getString("date");
				String time= resultset.getString("time");
				
				ScheduledCallInfo scheduledCall = new ScheduledCallInfo();
				
				scheduledCall.setCallId(callId);
				scheduledCall.setMyExtentionNo(myExtentionNo);
				scheduledCall.setName(name);
				scheduledCall.setCountry(country);
				scheduledCall.setNumber(number);
				scheduledCall.setDate(date);
				scheduledCall.setTime(time);
				
				scheduledCallInfo.add(scheduledCall);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not found calls");
		}
		finally
		{
			try {
				resultset.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("not closed connection");
			}
		}			
		
		System.out.println("operation done succesfully.");
		return scheduledCallInfo;
		
	}

	public void addContact(String nameConfBridge, String conType, String country, String numb, String altNumb) {
		Statement statement = null;		
		
		try {
			connect();
			statement= con.createStatement();
			statement.executeQuery("INSERT INTO Contacts (CONTACTNAME,CONNECTIONTYPE,COUNTRY,NUMBER,ALTERNATENUMBER) VALUES ('"+nameConfBridge+"','"+conType+"','"+country+"','"+numb+"','"+altNumb+"');");
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally{
			try {
				//resultset.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("not closed connection");
			}
		}
		
	}

	public List<Contacts> getContacts() {
		
		Statement statement = null;
		ResultSet resultset = null;
		List<Contacts> contactList = new ArrayList<Contacts>();		
		
		try {
			connect();
			statement=con.createStatement();
			resultset = statement.executeQuery("SELECT * FROM Contacts");
			
			while(resultset.next())
			{
				int contactId = resultset.getInt("contactId"); 
				String contactName = resultset.getString("contactName");
				String connectionType = resultset.getString("connectionType");
				String country = resultset.getString("country");
				String number = resultset.getString("number");
				String alternateNumber = resultset.getString("alternateNumber");
				
				Contacts contact= new Contacts();
				
				contact.setContactID(contactId);
				contact.setContactName(contactName);
				contact.setConnectionType(connectionType);
				contact.setCountry(country);
				contact.setNumber(number);
				contact.setAlternateNo(alternateNumber);
				
				contactList.add(contact);			
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				resultset.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("not closed connection");
			}
		}	
		
		System.out.println("contact list returned");
		return contactList;
	}
	

}
