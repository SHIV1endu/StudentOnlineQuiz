<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FacultyMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/menu.css" rel="stylesheet" type="text/css" media="all"/>
<script src="css/HoverMenu.js" type="text/javascript"></script>

  </head>
  
  <body>
    		 <ul id="nav">
 		 			<li class="top">
 					 <a href="FacultyHome.jsp" class="top_link"><span>Faculty Home</span> </a>						
					</li>
					<li class="top">
 					 <a href="AddSubject.jsp" class="top_link"><span>Add Subject</span> </a>						
					</li>
					<li class="top">
 					 <a href="AddTest.jsp" class="top_link"><span>Add Test</span> </a>						
					</li>
					<li class="top">
 					 <a href="AddQuestion.jsp" class="top_link"><span>AddQuestion</span> </a>						
					</li>
					 <li class="top">
 					 <a href="ViewTestQ.jsp" class="top_link"><span>ViewTestQ</span> </a>						
					</li>
					</li>
					 <li class="top">
 					 <a href="ViewResultstoadmin.jsp" class="top_link"><span>Reports</span> </a>					
					</li>
						<li class="top">
						<a href="ChangePassword.jsp" class="top_link"><span>Change Password</span></a>
					</li>
					<li class="top">
						<a href="LogoutAction.jsp" class="top_link"><span>Logout</span> </a>
					</li>
		</ul>
  </body>
</html>
