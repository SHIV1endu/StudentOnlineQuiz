<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dto.QuestionBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewQueslist.jsp' starting page</title>
    
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
			<center>
				<div style="height: auto; width: 650px; background-color: white;">
		   	       <div style="height: 20px;width: 650px;background-color:	#FF4500;"></div>
		   	       All Questions for :<%=session.getAttribute("tname") %>&nbsp;&nbsp;&nbsp;Test
		   	       <form action="">
						<table style="width: 550px;" border="0">
							<tr>
								<td colspan="2">
									<label
										style="color: #0000aa; font-style: italic; font-size: 20px;">
										<%											
											HashMap hm=(HashMap)session.getAttribute("hmv");
											
											System.out.print(hm.size());
										%>
									</label>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
							</tr>	
							<%
						QuestionBean dto=new QuestionBean();
							for(int i=1;i<=hm.size();i++){
							dto=(QuestionBean)hm.get(i);
							%>
							
							<tr >
							<td>
							<!--<table style="width: 400px;color: gray;">-->
							<tr><td>
							<%=i %><input type="hidden" name="<%=dto.getQuestionid() %>">&nbsp;&nbsp;&nbsp;<font style="color: red;"><%=dto.getQuestion() %></font>
					       
							</td></tr>
							
							
							</td>
							<td>
							<table style="width: 400px;color: gray;">
							
							<tr><td style="width: 100px;color: green;">Option 1:</td><td> &nbsp; </td> <td><%=dto.getOp1() %></td></tr>
							<tr><td style="color: green;">Option 2:</td><td> &nbsp; </td> <td><%=dto.getOp2()%></td></tr>
							<tr><td style="color: green;">Option 3:</td><td> &nbsp; </td> <td><%=dto.getOp3() %></td></tr>
							<tr><td style="color: green;">Option 4:</td><td> &nbsp; </td> <td><%=dto.getOp4() %></td></tr>
							<tr><td style="color: #C71585;">True Answer:</td><td> &nbsp; </td> <td><%=dto.getTruans()%></td></tr>
							
							</table>	
							</td>
							</tr>
								<tr style="background-color: silver;">
								<td colspan="2">
									&nbsp;
							
									&nbsp;
								</td>
							</tr>
							<%
							
							}
							 %>		
						 
		   	       </div>
		   	       </center>
  </body>
</html>
