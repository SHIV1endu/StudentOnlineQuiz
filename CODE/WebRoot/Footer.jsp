<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

		<title>My JSP 'Footer.jsp' starting page</title>



	</head>

	<body>
		<center>
		
			<!--<img src="images/footer.png" style="width: 1000px;">

		-->
		<div style="height: 30px;width: auto;background-color: yellow;">
			<font style="height: 16px; font-style: italic; color: black;">Developed By:- Shivendu Kumar</font>
		</div>
		</center>

	</body>
</html>
