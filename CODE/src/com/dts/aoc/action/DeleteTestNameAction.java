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

public class DeleteTestNameAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		HashMap hmpro=new AcceptTestNameDAO().getTestNameDetails();
		if(hmpro.size()>0){
			session.setAttribute("hmpro", hmpro);
			
	String target="TestInfo.jsp?status=Test Name ";
	RequestDispatcher rd=request.getRequestDispatcher(target);
	rd.forward(request, response);
		}
		else
		{
			String target="TestInfo.jsp?status=Test Name ";
			RequestDispatcher rd=request.getRequestDispatcher(target);
			rd.forward(request, response);
		
		}
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
