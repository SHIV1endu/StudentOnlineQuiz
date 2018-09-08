<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dto.AddSubjectDto"%>
<%@page import="com.dts.aoc.dao.AddSubjectdao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testq.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>

//var x_win = window.self; 
 <%
        String subjectid=request.getParameter("subjecttestid");
      System.out.println("in jsp courdeid is.............."+subjectid);
      
       %>


function goOn() {
var port=document.register.port.value;
var host=document.register.host.value;
var subjectName=document.register.subjecttestid.value;
window.location.href='http://'+host+':'+port+'/OnlineQuize/Testq?subjecttestid=<%=subjectid %>&sujectName='+subjectNam;

} 
</script>

  </head>
  
  <body>
 
  <form action="./Abc" name="register">
   <input type="hidden" name="port" value="<%=request.getLocalPort() %>">
    <input type="hidden" name="host" value="<%=request.getServerName() %>">
   <tr>
		   	       <td style="color: #0000CD;">Enter Subject  ID</td><td><select name="subjecttestid"  "onBlur="goOn()">
		   	        <%
		   	       HashMap hm=new AddSubjectdao().subjectid();
		   	       if(hm.size()>0){
		   	       for(int i=1;i<=hm.size();i++){
		   	       AddSubjectDto dtono=new AddSubjectDto();
		   	        dtono=(AddSubjectDto)hm.get(i);
		   	         %>
		   	         
		   	      <option value="<%=dtono.getSubjectid() %>"><%=dtono.getSubjectname() %></option>
		   	       
		   	      <%
		   	      }
		   	      }
		   	      
		   	       %>
		   	       </select>
		   	       </td>
		   	       </tr>
  
  
  
  
  
  
  </form>
  
  
  
  
  
  </select>
  </body>
</html>
