package com.callService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/EmpService")
public class EmployeeService {

	EmployeeDAO empDAO = new  EmployeeDAO();
	
	@GET
	@Path("/employee")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<EmployeeInfo> getAllEmployees(){
		return empDAO.getAllEmployees();
	}
	
	@GET
	@Path("/employeePosting")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void setEmployees(@QueryParam("empName") String empName, @QueryParam("yourDesk") String desk){
		empDAO.addEmployeeInfo(empName,desk);
	}
	
	@GET
	@Path("/ScheduleCall")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void scheduleCall(@QueryParam("empName") String empName,@QueryParam("myExtNo") String myExtNo,@QueryParam("externalNo") String externalNo,@QueryParam("yourDesk") String yourDesk,@QueryParam("nameConfBridge") String nameConfBridge, @QueryParam("conType") String conType, @QueryParam("country") String country, @QueryParam("numb") String numb, @QueryParam("altNumb") String altNumb, @QueryParam("addToContacts") String addToContacts, @QueryParam("date") String date, @QueryParam("time") String time){
		empDAO.scheduleCall(empName,myExtNo,externalNo,yourDesk,nameConfBridge,conType,country,numb,altNumb,addToContacts,date,time);
	}
	
	@GET
	@Path("/GetScheduledCalls")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ScheduledCallInfo> getScheduledCalls(){
		return empDAO.getScheduledCalls();
	}
	
	@GET
	@Path("/GetCallHistory")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ScheduledCallInfo> getCallHistory(){
		return empDAO.getCallHistory();
	}
	
	@GET
	@Path("/GetContacts")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Contacts> getContacts(){
		return empDAO.getContacts();
	}
	
	@GET
	@Path("/AddToContacts")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void addContact(@QueryParam("nameConfBridge") String nameConfBridge, @QueryParam("conType") String conType, @QueryParam("country") String country, @QueryParam("numb") String numb, @QueryParam("altNumb") String altNumb){
		empDAO.addContact(nameConfBridge,conType,country,numb,altNumb);
	}
	
	
	
	
	 @OPTIONS
	  @Path("/getsample")
	  public Response getOptions() {
	    return Response.ok()
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	  }
	
	
	@POST
	@Path("/postingEmp")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String createEmployee(EmployeeInfo emp)
	{
		 return "content added";
		
	}
}

