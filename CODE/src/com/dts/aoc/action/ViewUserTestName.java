package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.AcceptTestNameDAO;

public class ViewUserTestName extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		HashMap hmpro=new AcceptTestNameDAO().ViewUserTestInformation();
		   if(hmpro.size()>0){
			   
			 session.setAttribute("hmpro", hmpro);  
			   
		   }
		   else{
			 String target="UserTestInfo.jsp?status=Soory for Update";
			   
		   }
		  
		   String target="UserTestInfo.jsp?status=Welcome to my test ";
			RequestDispatcher rd=request.getRequestDispatcher(target);
			rd.forward(request, response);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}

}
