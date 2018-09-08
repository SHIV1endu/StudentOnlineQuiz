package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.dto.RegistrationBean;

public class RegistrationAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
RegistrationBean rb=new RegistrationBean();
rb.setUserID(request.getParameter("uid"));
rb.setPassword(request.getParameter("pass"));
rb.setUserName(request.getParameter("uname"));
rb.setUserEmail(request.getParameter("email"));
rb.setUserMobile(request.getParameter("mob"));
rb.setUserDOB(request.getParameter("eventdate"));
rb.setUserGender(request.getParameter("g"));
rb.setUserType(request.getParameter("utype"));
//rb.setUserType("USER");
rb.setUserAddress(request.getParameter("uaddress"));
String target = "Registration.jsp?status=Registration Failed  !!!!!";
boolean flag1=new ProfileDAO().checkLoginIDExisted(request.getParameter("uid"));
if(flag1==true){
	 target = "Registration.jsp?status=This "+flag1+" login ID is not present!!";
}
else{
	boolean f=new ProfileDAO().insertLoginInfo(rb);
	boolean f1=new ProfileDAO().insertUserInfo(rb);
	if(f==true&&f1==true){
	target = "Login.jsp?status=Welcome Account is created successfully";
	}else{
		target = "Registration.jsp?status=Registration Failed  !!!!!";	
	}
}
RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);  

out.flush();
out.close();
}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
doGet(request,response);
out.flush();
out.close();
}
}
