<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserRegisterBeforeTeststart.jsp' starting page</title>
    
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
		   	        <form action="./UserRegisterBeforeTeststartAction">
		   	        <%
		   	        
		   	        String tname=request.getParameter("testname");
		   	        String subjectid=request.getParameter("subjectid");
		   	        System.out.print("registration-t-->"+tname);
		   	        System.out.print("registration--sid->"+subjectid);
		   	        String status=request.getParameter("status");
		   	        if(status !=null){
		   	        out.print(status);
		   	        
		   	        }
		   	         %>
		   	         <fieldset>
		   	        
		   	        <legend>Online Quize:</legend>
		   	         <table>
		   	         <tr>
		   	         <td>
		   	         
		   	         <input type="hidden" name="testname" value="<%=tname %>">
		   	          <input type="hidden" name="subjectid" value="<%=subjectid %>">
		   	         </td>
		   	         
		   	         </tr>
		   	          <tr>
		   	          <td>
		   	         Candidate Name
		   	          
		   	          </td>
		   	          <td><input type="text" name="cname" id="cname"/></td>
		   	          </tr>
		   	          <tr>
		   	          <td>
		   	         Candidate Email id
		   	          
		   	          </td>
		   	          <td><input type="text" name="email" id="email"/></td>
		   	          </tr>
		   	           <tr>
		   	          <td>
		   	         Phone
		   	          
		   	          </td>
		   	          <td><input type="text" name="phone" id="phone"/></td>
		   	          </tr>
		   	      <td></td>
		   	      <tr>
		   	      <td></td><td><input type="submit" name="" value="ClickMe"/>
		   	     </td>
		   	      </tr>
		   	        </table>
		   	        
		   	        
		   	        </fieldset>
		   	        <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	       </form>
		   	        
		   	       
		   	 </div>   
  </center>
  </body>
</html>