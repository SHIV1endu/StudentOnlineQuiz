<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddSubject.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>
	<script type="text/javascript">
	
	 function validate(){
	 document.getElementById("msgsubject").innerHTML=" ";
	
	 if (document.getElementById("subjectname").value == "") {

		document.getElementById("msgsubject").innerHTML = "Please Enter Subject Name ?";
		return false;
	}
	 
	 
	 var subjectname = document.getElementById("subjectname");
	  var filter = /^([a-zA-Z])+$/;
	if (!filter.test(subjectname.value)) {
		document.getElementById("msgsubject").innerHTML = "Please Enter only charecter !";
		return false;
	}
	
	 }
	
	
	
	</script>

  </head>
  
  <body>
  <div style="width: 1000px; height: auto; margin-top: -15px;"></div>
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="FacultyMenu.jsp"></jsp:include>
			</div>
			<br>
			<center>
		   	<div style="height: 350px; width: 500px; background-color: white;">
		   	       <div style="height: 20px;width: 500px;background-color:	#FF4500;"></div>
		   	       <form action="./AddSubjectAction" method="get"  name="event1"
							onsubmit="return validate();">
		   	       <h3>Add Subject</h3>
		   	       <hr color="#00FF00"><br/>
		   	       <table>
		   	       <tr>
		   	       <td style="color: #0000CD;">Subject Name</td><td><input type="text" name="subjectname" id="subjectname" style=" color: green; "/>
		   	    
		   	      </td>
		   	       </tr>
                 <tr><td></td><td></td></tr>
                    
		   	        <tr>
		  	    
		   	       <td></td><td><input type="submit" value="AddSubject" style="background-color: #191970;color:white;"/></td>
		   	       </tr>
		   	    
		   	       
		   	       
		   	       </table>
		   	       
		   	       
		   	       </form>
		   	        <hr color="#00FF00">
		   	          <label id="msgsubject" style="color: red; font-size: 16px; font-style: italic;"></label>
		   	       
		   	        <label style="color:  red;">
		   	        <%
		   	        String status=request.getParameter("status");
		   	        if(status !=null){
		   	        out.print(status);
		   	        
		   	        }
		   	        
		   	        
		   	         %>
		   	         </label>
		   	       </div>
		   	        <div style="height: 20px;width: 500px;background-color:	#FF4500;"></div>
				
			</center>
			
			
  </body>
</html>
