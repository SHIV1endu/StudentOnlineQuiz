<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FinalResultByStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div style="width: 1000px; height: auto; margin-top: -15px;"></div>
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="UserMenu.jsp"></jsp:include>
			</div>
			
			<center>
				<div style="height: auto; width: 650px; background-color: white;">
		   	       
		   	       <div style="height: 20px;width: 650px;background-color:	#FF4500;"></div>
		   	      <div style="background-color: #B0C4DE;height: 130px;">
		   	     
		   	     
		   	     <table style="width: 600px;">
					<tr>
						<td>
							<label>
								<font style="color: red; font-size:15px;">UseID:</font> <%=session.getAttribute("userid") %>
							</label>
						</td>
						<td>
							<label>
								Name:<%=session.getAttribute("name") %>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label>
								Email ID: <%=session.getAttribute("email") %>
							</label>
						</td>
						<td>
							<label>
							
								Phone no: <%=session.getAttribute("phone") %>
								
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label>
								Test Name: <%=session.getAttribute("testname") %>
							</label>
						</td>
						<td>
							<label>
								Subject: <%=session.getAttribute("subjectid") %>
							</label>
						</td>
					</tr>
				</table>
		   	       </div>
		   	    
		   	      <div style="width: 590px; text-align: justify;">
				  <div style="width: 290px; float: left; background-color: #c8ff00;">
					<table style="width: 290px;">
						<tr style="color: red;">
							<td>
								QN
							</td>
							<td>
								SA
							</td>
							<td>
								CA
							</td>
						</tr>
						<%
		   	      
		   	        
		   	       for(int i=1;i<=20;i++){
		   	      String id=(String) session.getAttribute("quid"+i);
		   	      String answer=(String)session.getAttribute("snas"+i);
		   	      String truea=(String)session.getAttribute("cansad"+i);
		   	       
		   	       %>
		   	       <tr>
							<td>
								<%= id%>
							</td>						
							<td>
								<%=answer %>
							</td>
							
								<td>
								<%=truea %>
							</td></tr>
					<%} %>
						
			</table>
				</div>
		   	       
		   	     <div style="width: 290px; float: left; background-color: yellow;">
					<table style="width: 290px;">
						<tr>
							<td>
								Total Question: 20
							</td>
						</tr>
						<tr>
							<td>
								Correct Question: <%=session.getAttribute("ncorrectans")%>
							</td>
						</tr>
						<tr>
							<td>
								Wrong Question: <%=session.getAttribute("wnumberofans")%>
							</td>
							
						</tr>
						
						<tr>
						<td>
						<br/>
						
						 Remark: 
							</td>
						</tr>
						<%
						int tot=(Integer)session.getAttribute("ncorrectans");
				           
						   if(tot>12){
						   %>
						   <tr>
							<td>
								Congratulation Your are qualified
								please come with our academic document 
								<p style="color: traffic orange;">
							
							 I declare that all the information that 
							 I have provided here is correct and that 
							 I am fully capable of handling all tasks that I mentioned here. 
							 If you feel the need to verify this information, you may contact Mr.
							 George Mason who was my supervisor at Connecticut 
							  Mansions and he will vouch for me on a personal level.
							</p>
							<p>
						  Sincerely,
                          Heather Graham
                          Creek Avenue
                         
							
							
							</p>
							</td>
							
						   </tr>
						
						   <% }
						   
						   
						   else{%>
						  
						   <tr>
						   <td>
						   <br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
						
						   <td> Sorry You are not qualified please try .......</td>
						 </tr>
						    <%  }%>
						    
						    
						  		<tr>
							   <td>
								<!--<a href="#">Download</a>
							--></td>
						</tr>
					</table>
				</div>
		   	     
			
			</div>
			 <div style="height: 20px;width: 650px;background-color:	#FF4500;"></div>
			</center>
  </body>
</html>
