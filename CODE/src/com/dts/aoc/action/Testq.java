package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dts.aoc.dao.AddSubjectdao;
import com.dts.aoc.dto.AddSubjectDto;

public class Testq extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target=null;
	
		      String subjectid=null;
		      String questionno=null;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AddSubjectDto dto=new AddSubjectDto();
		subjectid=request.getParameter("subjecttestid");
		
		
			 
			boolean flag= new AddSubjectdao().chicksubjectname(subjectid);
		
			       

			if (flag==false)
			{
				 target="abc";
			}
			
		
	
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

		
	


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}

	

}
