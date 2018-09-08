<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dto.AddSubjectDto"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserTestInfo.jsp' starting page</title>
    
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
			<div style="margin-top: -3px;"><jsp:include page="UserMenu.jsp"></jsp:include>
			</div>
			
			<center>
		   	<div style="height: 350px; width: 600px; background-color: white;">
		   	       <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	         Welcome to Online Quize
		   	        <form >
		   	        
		   	         <fieldset>
		   	        
		   	        <legend>Online Quize:</legend>
		   	         <table>
		   	      
		   	       <% 
		   	        String status=request.getParameter("status");
		   	        if(status !=null){
		   	       
		   	        }
		   	        
		   	        HashMap hmpro=(HashMap)session.getAttribute("hmpro");
		   	        System.out.print("size of hmpro---->"+hmpro.size());
		   	        
		   	        if(hmpro.size()>0){
		   	        for(int i=1;i<=hmpro.size();i++){
		   	          AddSubjectDto dto=new AddSubjectDto();
		   	          dto=(AddSubjectDto)hmpro.get(i);
		   	        
		   	        
		   	      
		   	        
		   	       %>
		   	        <tr>
		   	         <td> <input type="image" src="images/new2.gif" height="20" width="30">&nbsp;&nbsp;&nbsp;<a href="UserConformBeforeTest.jsp?tname=<%=dto.getTestname() %>&subjid=<%=dto.getSubjectid() %>" style="color: red; size: 30px;"> <%=dto.getTestname() %> &nbsp;&nbsp;&nbsp;for &nbsp;&nbsp;&nbsp;<%=dto.getSubjectid() %></a></td>
		   	    
		   	        
		   	          <%
		   	      
		   	        
		   	        }
		   	        
		   	        
		   	        }
		   	       %>
		   	        
		  	          </tr> 
		   	      
		   	        </table>
		   	        
		   	        
		   	        </fieldset>
		   	        <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	       </form>
		   	        
		   	       
		   	 </div>   
  </center>
  </body>
</html>