<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.dae.dto.RegistrationBean"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'NewUserAccept.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
	</head>

	<body>
		<div>
			<jsp:include page="Header.jsp"></jsp:include>
		</div>
		<div>
			<jsp:include page="AdminMenu.jsp"></jsp:include>
		</div>
		
		<center>
		<div style="height: 300px;; width: 500px; background-color: #A9A9A9; margin: 20px;">
			<div style="height: 300px;; width: 500px; background-color: #A9A9A9; margin: 20px;">
			
							<%
								String userinfo = request.getParameter("status");
								if (userinfo != null) {

								}
								try
								{
								HashMap hmpro = (HashMap) session.getAttribute("hmpro");
							if(hmpro.size()>0)
							{

								String msg = (String) session.getAttribute("acceptuser");
								session.setAttribute("acceptuser", " ");
								if (msg != null) {
							%>
							<label style="color: red; size: 20px;" ><%=msg%></label>
							<%
								}
								else
								{
								out.println("No Pending Requests");
								}
							%>
						<table>
			<tr>
			<td>

					<%
						if (hmpro.size() > 0) {
					%>
						  <tr>
                           <th>UserId</th>
                            <th>Name</th>
                            <th>UserType</th>
                             <th>RequestUser</th>
                             <th>RejectUser</th>
                             <th>DeleteUser</th>
                           </tr>
			
					<%
						for (int i = 1; i <= hmpro.size(); i++) {
								RegistrationBean rb= (RegistrationBean) hmpro.get(i);
					%>
					<tr>
						<td>
							<%=rb.getUserID()%>
						</td>
						<td>
							<%=rb.getUserName()%>
						</td>
						<td>
							<%=rb.getUserType()%>
						</td>
						
						<td>
							 <a
								href="AcceptAccount.jsp?id=<%=rb.getUserID()%>">accept account</a> 
						</td>
						<td>
							 <a
								href="RejectAccount.jsp?id=<%=rb.getUserID()%>">Reject</a> 
						</td>
						<td>
							 <a
								href="DeleteAccount.jsp?id=<%=rb.getUserID()%>">Delete</a> 
						</td>
					</tr>
					<%
						}
						}
						}
						else
						{
						out.println("no recrods found");
						}
						}
						catch(Exception e)
						{
					out.println("no recrods found");
						}
					%>
		
			
			</table>
			
</div>
<div  style="height: 30px;; width: 500px; background-color:#FFA500; margin: 20px;"></div>
			</div>
		</center>
	</body>
</html>
