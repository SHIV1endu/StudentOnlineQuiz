package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.dto.RegistrationBean;

public class LoginAction extends HttpServlet {
	private String utype="";
	private String username="";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RegistrationBean rb=new RegistrationBean();
		
		session.setAttribute("userid",request.getParameter("uid"));
		
		
		
		rb.setUserID(request.getParameter("uid"));
		rb.setPassword(request.getParameter("pass"));
		RegistrationBean rb1=new RegistrationBean();
	
		rb1=new SecurityDAO().loginCheck(rb);
		
		utype=rb1.getUserType();
		username=rb1.getUserName();
		
		
		session.setAttribute("utype",utype);
		System.out.println(utype);
		
		String target = "Login.jsp?status=Invalid username and password";
		
		session.setAttribute("uid", request.getParameter("uid"));
        if(utype.equals("ADMIN"))
        {          
           target = "AdminHome.jsp?status=Welcome "+username;
           session.setAttribute("user",username);
           session.setAttribute("role",utype);
        } 
        else if(utype.equals("USER"))
        {
           target = "UserHome.jsp?status=Welcome "+username;  	
           session.setAttribute("user",username);
           session.setAttribute("role",utype);
           
        } 
        else if(utype.equals("FACULTY"))
        {
           target = "FacultyHome.jsp?status=Welcome "+username;  	
           session.setAttribute("user",username);
           session.setAttribute("role",utype);
           
        } 
        else { 
           target = "Login.jsp?status=Invalid username and password";
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
