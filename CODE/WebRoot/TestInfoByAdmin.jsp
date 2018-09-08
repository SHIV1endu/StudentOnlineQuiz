
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dto.AddSubjectDto"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TestInfoByAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
fieldset {
position:relative;
margin-top:50px;
height:300px;
background:#ffffcc;
padding-top:20px;
}
legend {
 
 top:-10px;
 background:blue;
 color:white;
 border:1px solid #000; 
 border-color:red;
 padding:2px 5px;
}
</style>

  </head>
  
  <body>
   <div style="width: 1000px; height: auto; margin-top: -15px;"></div>
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="AdminMenu.jsp"></jsp:include>
			</div>
			<br>
			
			<center>
			   <%
		   	        	String userinfo = request.getParameter("status");
		   	        	if (userinfo != null) {

		   	        	}
		   	        	try
		   	        	{
		   	        	HashMap hmpro = (HashMap) session.getAttribute("hmpro");
		   	        	%>
		   	<div style="height: 350px; width: 600px; background-color: white;">
		   	       <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	       <label style="color: green;">
		   	        </label>
		   	        <h3 style="font-style: italic; color: red;">Test Name Information</h3>
		   	       <form action="">
		   	       
		   	       
		   	      
		   	       
		   	     <hr color="#00FF00"><br/>
		   	       <fieldset>
		   	        
		   	        <legend>Test Name Information:</legend>
		   	       
		   	        
		   	        <table>
		   	       
		   	         
		   	         <tr style="background-color: #990000; color: yellow; height: 40px; size: 19px;">
		   	         <th>SNo</th><th>TestName</th><th>Subject Name</th><th>TotQues</th><th>Date</th><th>Accept</th><th>Reject</th><th>Delete</th>
		   	         </tr>
		   	         
		   	         <%
		   	      

		   	        	String msg = (String) session.getAttribute("acceptuser");
		   	        	session.setAttribute("acceptuser", " ");

		   	        	if (hmpro.size()> 0) {
		   	        		for (int i = 1; i <= hmpro.size(); i++) {
		   	        			AddSubjectDto dto = new AddSubjectDto();

		   	        			dto = (AddSubjectDto) hmpro.get(i);
		   	        %>
                             <tr style=" background-color: white;">
								<td><%=i %></td>
								<td><%=dto.getTestname()%></td>
								<td><%=dto.getSubjectid()%></td>
								<td><%=dto.getTotalnoQuestion()%></td>
								<td><%=dto.getAaddate()%></td>
								<td>
									<a href="AcceptTestName.jsp?sno=<%=dto.getSno() %>">Accept</a>
								</td>
								<td>
									<a href="RejectTestName.jsp?sno=<%=dto.getSno() %>">Reject</a>
								</td>
								<td>
								<a href="DeleteTestName.jsp?sno=<%=dto.getSno() %>">Delete</a>	
								</td>


								<%
									}

									}
									
								%>
		   	        
		   	        
		   	        
		   	         </tr>
		   	         
		   	         
		   	        </table>
		   	        <br/>
		   	        <label style="color: green;">
		   	        <%
		   	        if(msg !=null){
		   	        out.print(msg);
		   	        }
		   	       %>
		   	        
		   	        
		   	        </label>
		   	        
		   	        </fieldset>
		   	       
		   	       
		   	       
		   	       
		   	       <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	       </form>
		   	        
		   	       
		   	 </div>   
		   	 <%
		   	  }
									catch(Exception e)
									{
								out.println("No Tests Found");
									
									}
		   	        
		   	         %>
		   	 
		   	 
		   	 
  </center>
							  </body>
</html>
