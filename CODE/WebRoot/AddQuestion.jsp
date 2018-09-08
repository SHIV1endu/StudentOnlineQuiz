<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dao.AddSubjectdao"%>
<%@page import="com.dts.aoc.dto.AddSubjectDto"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddQuestion.jsp' starting page</title>
    
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
			<div style="margin-top: -3px;"><jsp:include page="FacultyMenu.jsp"></jsp:include>
			</div>
			<br>
			<center>
		   	<div style="height: 350px; width: 500px; background-color: white;">
		   	       <div style="height: 20px;width: 500px;background-color:	#FF4500;"></div>
		   	       <form action="./AddQuestionAction " method="get"  name="event1"
							onsubmit="return validate();">
		   	       <h3>Test</h3>
		   	       <hr color="#00FF00"><br/>
		   	       <table>
		   	       
		   	        <tr>
		   	       <td style="color: #0000CD;">Select Test Name</td><td><select name="testname">
		   	        <%
		   	       HashMap hm=new AddSubjectdao().testname();
		   	       if(hm.size()>0){
		   	       for(int i=1;i<=hm.size();i++){
		   	       AddSubjectDto dtono=new AddSubjectDto();
		   	        dtono=(AddSubjectDto)hm.get(i);
		   	         %>
		   	         
		   	      <option value="<%=dtono.getTestname() %>"><%=dtono.getTestname() %></option>
		   	       
		   	      <%
		   	      }
		   	      
		   	      }
		   	      
		   	       %>
		   	       </select>
		   	       </td>
		   	       </tr>
		   	      
                 <tr><td></td><td></td></tr>
                    
		   	        <tr>
		  	    
		   	       <td></td><td><input type="submit" value="AddTest" style="background-color: #191970;color:white;"/></td>
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