<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dao.NewUserAcceptance"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AcceptAccount.jsp' starting page</title>
    
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
  <div>
	<jsp:include page="Header.jsp"></jsp:include>
		</div>
		<div>
			<jsp:include page="AdminMenu.jsp"></jsp:include>
		</div>
		 <% 
       String id=request.getParameter("id");
      new NewUserAcceptance().getAcceptNewUser(id);
 
      session.setAttribute("acceptuser","Account active now");
  
  // call a method to change the staus the
         String target = "./NewUserAction";
		 RequestDispatcher rd = request.getRequestDispatcher(target);
		 rd.forward(request, response);
  
   %>
  </body>
</html>
