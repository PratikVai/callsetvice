
//Submitting the form in json format


/*

$(document).on('pageinit', '#callSchedulling', function () {
    $("#submitBtn").click(function () {
		if($("#addToContacts").is(":checked")){
			$.ajax({
				type:"GET",
				url:"http://localhost:8085/BuzzService/rest/EmpService/AddToContacts",
				dataType:"xml",
				success: function (data) {                   
                    $(data).find('Employee').each(function () {
                        var id = $(this).find('id').text();
                        var name = $(this).find('name').text();
                        
                        alert(id) ;
						alert(name);                     
                    });
                },
                error: function (xhr) {
					alert("error")
                    alert(xhr.responseText);
                }			
				
			});     

    	}
	});
});*/


 $(document).on('pageinit','#contacts',function() {

     $.ajax({
                type: "GET",
                url: "http://localhost:8085/BuzzService/rest/EmpService/GetContacts",
                dataType: "xml",
                success: function (data) {                   
                    $(data).find('Contact').each(function () {
                        var contactId = $(this).find('contactID').text();
                        var contactName = $(this).find('contactName').text();
						var connectionType = $(this).find('connectionType').text();
						var country = $(this).find('country').text();						
						var number = $(this).find('number').text();
						var alternateNo = $(this).find('alternateNo').text();
						
                        
                        $('#contactNames').append('<li class="ui-btn">' + contactName+"   " +number+" "+'</li>');                     
                    });
                },
                error: function (xhr) {
					alert("error")
                    alert(xhr.responseText);
                }
            });
});




//  retriving data from local storage and displaying it in list

/*$(document).on('pageinit', '#myScheduledCalls', function () {
   $.ajax({
                type: "GET",
                url: "http://localhost:8085/BuzzService/rest/EmpService/ScheduleCall",
                dataType: "xml",
                success: function (data) {                   
                    $(data).find('Employee').each(function () {
                        var id = $(this).find('id').text();
                        var name = $(this).find('name').text();
                        
                        alert(id) ;
						alert(name);                     
                    });
                },
                error: function (xhr) {
					alert("error")
                    alert(xhr.responseText);
                }
            });

});*/

$(document).on('pageinit', '#callHistory', function () {
		
     //$.get('http://localhost:8085/BuzzService/rest/EmpService/employee', function(data) { alert(data); });
	   
	  $.ajax({
                type: "GET",
                url: "http://localhost:8085/BuzzService/rest/EmpService/GetCallHistory",
                dataType: "xml",
                success: function (data) {                   
                    $(data).find('ScheduledCall').each(function () {
                        var id = $(this).find('callId').text();
                        var name = $(this).find('name').text();
						var country = $(this).find('country').text();
						var date = $(this).find('date').text();
						var time = $(this).find('time').text();
						var number = $(this).find('number').text();
                        
                        $('#myCallHistory').append('<li class="ui-btn">' + name+"   " +country+"  "+number+"  "+date+"  "+time+'</li>');                     
                    });
                },
                error: function (xhr) {
					alert("error")
                    alert(xhr.responseText);
                }
            });
	   
	   
});
	
	 $(document).on('pageinit', '#myCalls', function () {
		
       //$.get('http://localhost:8085/BuzzService/rest/EmpService/employee', function(data) { alert(data); });
	   
	   $.ajax({
                type: "GET",
                url: "http://localhost:8085/BuzzService/rest/EmpService/GetScheduledCalls",
                dataType: "xml",
                success: function (data) {                   
                    $(data).find('ScheduledCall').each(function () {
                        var id = $(this).find('callId').text();
                        var name = $(this).find('name').text();
						var country = $(this).find('country').text();
						var date = $(this).find('date').text();
						var time = $(this).find('time').text();
						var number = $(this).find('number').text();
                        
                        $('#myScheduledCalls').append('<li class="ui-btn">' + name+"   " +country+"  "+number+"  "+date+"  "+time+'</li>');                     
                    });
                },
                error: function (xhr) {
					alert("error")
                    alert(xhr.responseText);
                }
            });
	   
    });
	
	
	
	  






