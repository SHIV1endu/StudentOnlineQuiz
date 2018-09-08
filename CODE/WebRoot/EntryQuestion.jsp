<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EntryQuestion.jsp' starting page</title>
    
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
			String subjectid=(String)session.getAttribute("subjectid");
			System.out.println("Subject name--->jsp-->"+subjectid);
			String testname=(String)session.getAttribute("tname");
				System.out.println("testname name--->jsp-->"+testname);
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
		   	       <form action="./QuestionAnsAction">
		   	     <hr color="#00FF00"><br/>
		   	       <fieldset>
		   	        
		   	        <legend>Add Question:<%=n %></legend>
		   	       
		   	        
		   	        <table>
		   	        <tr>
		   	        <td><input type="hidden" name="subjectid" value="<%=subjectid %>"/></td>
		   	         <td><input type="hidden" name="testname" value="<%=testname %>"/></td>
		   	        </tr>
		   	         <tr>
		   	          <td>Q<%=n %><textarea cols="50" rows="3" name="Question"></textarea></td>
		   	         </tr>
		   	         <tr>
		   	         <td>Option 1<input type="text" name="op1" value=""/></td>
		   	         </tr>
		   	         <tr>
		   	         <td>Option 2<input type="text" name="op2" value=""/></td>
		   	         </tr>
		   	         <tr>
		   	         <td>Option 3<input type="text" name="op3" value=""/></td>
		   	         </tr>
		   	         <tr>
		   	         <td>Option 4<input type="text" name="op4" value=""/></td>
		   	         </tr>
		   	         <tr>
		   	         <td>True Ans<input type="text" name="tans" value=""/></td>
		   	         </tr>
		   	         <tr>
		   	         <td>
		   	         <input type="hidden" name="qsno" value="<%=n %>"/>
		   	         
		   	         </td>
		   	         </tr>
		   	         <tr>
		  	    
		   	       <td><input type="submit" value="AddSubject" style="background-color: #191970;color:white;"/></td>
		   	       </tr>
		   	        </table>
		   	        
		   	        
		   	        </fieldset>
		   	       
		   	       
		   	       
		   	       
		   	       <div style="height: 20px;width: 600px;background-color:	#FF4500;"></div>
		   	       </form>
		   	        
		   	       
		   	 </div>   
  </center>
  </body>
</html>
