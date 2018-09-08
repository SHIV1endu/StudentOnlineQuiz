<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AdminHome.jsp' starting page</title>
    
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>

  </head>
  
  <body>
         <center>
        <% String u=(String)session.getAttribute("user"); if(u==null){
        String target = "Login.jsp?status=Please enter username and password";        
         RequestDispatcher rd = request.getRequestDispatcher(target);
       rd.forward(request,response);
         
        } %>      
          <div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="AdminMenu.jsp"></jsp:include></div>
			<div class="signup" style="margin-top: -1px; width: 100%;">
			<center>
		
                 <div style="background-image:url('images/home_msg_back.jpg'); margin-top: -5px; color: black; font-size: 30px; text-align: center; height: 300px; ">
          <br/><br/><br/>
          <label style="color: white; font-style:italic; margin-left: 121px; ">Welcome <% String status=(String)session.getAttribute("user"); if(status!=null){out.println(status);} %></label>      
      
          </div>
			</center>
			</div>
			<div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
			</div>
		</div>   
		</center>
  </body>
</html>
