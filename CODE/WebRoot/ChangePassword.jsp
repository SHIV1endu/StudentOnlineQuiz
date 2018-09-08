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

		<title>My JSP 'ChangePassword.jsp' starting page</title>

		<link href="css/a.css" rel="stylesheet" type="text/css" media="all" />

		<script type="text/javascript">
function validator() {

	document.getElementById("msgoldpass").innerHTML = "";
	document.getElementById("msgnewpass").innerHTML = "";
	document.getElementById("msgchangedpass").innerHTML = "";
	document.getElementById("alertmsg").innerHTML = "";

	if (document.getElementById("opass").value == "") {

		document.getElementById("msgoldpass").innerHTML = "Plealse Enter Old Password";
		return false;
	} else if (document.getElementById("pass").value == "") {

		document.getElementById("msgnewpass").innerHTML = "Plealse Enter New Password";
		return false;
	} else if (document.getElementById("cpass").value == "") {
		document.getElementById("msgchangedpass").innerHTML = "Plealse Enter Confirm Password";
		return false;
	} else if (document.getElementById("cpass").value != document
			.getElementById("pass").value) {
		document.getElementById("alertmsg").innerHTML = "New Password is not matched with confirm password";
		return false;

	}

}
</script>

	</head>

	<body>
<center>
		<%
			String u = (String) session.getAttribute("user");
			if (u == null) {
				String target = "Login.jsp?status=Please enter username and password";
				RequestDispatcher rd = request.getRequestDispatcher(target);
				rd.forward(request, response);
			}
		%>
		<div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			<%
					String role = (String) session.getAttribute("role");
					if (role.equals("ADMIN")) {
				%>
				<div style="margin-top: -5px;"><jsp:include page="AdminMenu.jsp"></jsp:include></div>
				<%
					}
					if (role.equals("USER")) {
				%>
				<div style="margin-top: -3px;"><jsp:include page="UserMenu.jsp"></jsp:include></div>
				<%
					}
					
					if(role.equals("FACULTY")){
					
					
					
				%>
				<div style="margin-top: -3px;"><jsp:include page="FacultyMenu.jsp"></jsp:include></div>

<%
}
 %>
			<div class="signup" style="margin-top: -1px; width: 100%;">
				<center>
				

<form action="./ChangePasswordAction" onsubmit="return validator();">
					<table>
						<tr>
							<td colspan="2" style="">
								<label
									style="color: red; font-style: italic; text-align: center;">
									<%
										String status = request.getParameter("status");
										if (status != null) {
											out.println(status);
										}
									%>
								</label>
							</td>
						</tr>
						<tr>
							<td>
								<p>
									Old Password :
									<span class="dot">*</span>
								</p>
							</td>
							<td>
								<input type="password" name="opass" id="opass"
									class="input_password" value="">
								<label id="msgoldpass"
									style="color: red; font-size: 16px; font-style: italic;"></label>
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
						<tr>
							<td>
								<p>
									New Password :
									<span class="dot">*</span>
								</p>
							</td>


							<td>
								<input type="password" name="pass" id="pass"
									class="input_password" value="">
								<label id="msgnewpass"
									style="color: red; font-size: 16px; font-style: italic;">
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
						<tr>
							<td>
								<p>
									Confirm Password :
									<span class="dot">*</span>
								</p>
							</td>
							<td>
								<input type="password" name="cpass" id="cpass"
									class="input_password" value="">
								<label id="msgchangedpass"
									style="color: red; font-size: 16px; font-style: italic;"></label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td>
								<label id="alertmsg"
									style="color: red; font-size: 16px; font-style: italic;"></label>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="submit" class="submit" value="Change Password">
							</td>
						</tr>
					</table>
				</form> 
				</center>
			</div>
			<div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
			</div>
		</div>
		</center>
	</body>
</html>
