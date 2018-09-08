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

		<title>My JSP 'AboutUs.jsp' starting page</title>
		<link href="css/a.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>
		<center>
			<div style="width: 1000px; height: auto; margin-top: -15px;">
				<jsp:include page="Header.jsp"></jsp:include>
				<div style="margin-top: -3px;"><jsp:include page="Menu.jsp"></jsp:include></div>

				<div class="signup" style="margin-top: -1px; width: 1000px;">
					<center><p><b><h1>Online Quiz </h1></b></p>
						<br />
						<br />
						<br />
						<p><b><h1>Devloped by:Shivendu Kumar</h1></b><br>
						<p><b><h3>Title:Online Quiz</h3></b></p>
						<p><h5>This project is based on web based and another advantage is minimum time consume,best performance,secure etc.<br>
						This web application is paper less.</h5></p>
						<br />
						<br />
						<br />
						<p><h3>Under guidance:- MOHD. RAFEEQ</h3></p>
						<br />
						<br />
					</center>
				</div>
				<div style="margin-top: -3px;">
					<jsp:include page="Footer.jsp"></jsp:include>
				</div>
			</div>
		</center>
	</body>
</html>
