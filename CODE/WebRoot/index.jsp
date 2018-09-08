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

		<title>Welcome</title>


		<link rel="stylesheet" type="text/css" href="css/a.css">

	</head>
	<body>
	<center>
		<div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="Menu.jsp"></jsp:include></div>

			<div >
				<!--<img src="images/bhn1.PNG" style="width: 1000px; height: 20px;">
				
			--></div>
			<div style="height: 250px;width: 140px;"><!--
				<img src="images/welcome.PNG" style="width: 450px; height: 300px; margin: 30px;">
				
				--></div>
				<p style="color: white;">
Welcome to Online exam. This site will provide the quize for various subject of Interest.You neeed to login for the take the online
Examination is a growing need day-by- day because of the  24x7 lifestyle.In the traditional offline mode there is a requirement  of 
a group of people at the same time to take and give the examination maintaining all the authentic practice or transparency.
To solve this Problem or  we can say that to facilitate the requirement here is the answer-Online Examination because there is no boundation of time/place.
			<div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
			</div>
		</div>
		</center>
	</body>
</html>
