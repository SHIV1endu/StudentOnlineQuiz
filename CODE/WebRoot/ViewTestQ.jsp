<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dao.AddSubjectdao"%>
<%@page import="com.dts.aoc.dto.QuestionBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewTestQ.jsp' starting page</title>
    
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
			<div style="margin-top: -3px;"><jsp:include page="FacultyMenu.jsp"></jsp:include>
			</div>
			<br>
			<%
			
			int n=(Integer)session.getAttribute("num");
			 %>
			<center>
		   	<div style="height: 350px; width: 600px; background-color: white;">
		   	       <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	       <label style="color: green;">
		   	       <% 
		   	        String status=request.getParameter("status");
		   	        if(status !=null){
		   	        out.print(status);
		   	        }
		   	       %>
		   	      
		   	       
		   	       
		   	       </label>
		   	       <form action="./ViewQuestionList">
		   	     <hr color="#00FF00"><br/>
		   	       <fieldset>
		   	        
		   	        <legend>View Question:</legend>
		   	       
		   	        
		   	       <table>
		   	       
		   	        <tr>
		   	       <td style="color: #0000CD;">Select Test Name</td><td><select name="testname">
		   	       <%
		   	       HashMap hm=new AddSubjectdao().getTestName();
		   	       if(hm.size()>0){
		   	       for(int i=1;i<=hm.size();i++){
		   	       QuestionBean tname=new QuestionBean();
		   	        tname=(QuestionBean)hm.get(i);
		   	         %>
		   	         
		   	      <option value="<%=tname.getTestname()%>"><%=tname.getTestname() %></option>
		   	       
		   	      <%
		   	      }
		   	      
		   	      }
		   	      
		   	       %>
		   	       </select>
		   	       </td>
		   	       </tr>
		   	      
		  	    <tr>
		   	       <td><input type="submit" value="View" style="background-color: #191970;color:white;"/></td>
		   	       </tr>
		   	        </table>
		   	        
		   	        
		   	        </fieldset>
		   	       
		   	       
		   	       
		   	       
		   	       <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	       </form>
		   	        
		   	       
		   	 </div>   
  </center>
  </body>
</html>
