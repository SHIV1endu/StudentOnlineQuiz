package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.aoc.dao.AddSubjectdao;
import com.dts.aoc.dto.AddSubjectDto;

public class AddSubjectAction extends HttpServlet {

	String target = null;
	String subjectname = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AddSubjectDto dto = new AddSubjectDto();
		String subjectname = request.getParameter("subjectname");
		dto.setSubjectname(subjectname);
		boolean f2=new AddSubjectdao().chicksubjectname(subjectname);
		
		boolean f1 = new AddSubjectdao().addSubject(dto);
		if (f1 == true) {
			target = "AddSubject.jsp?status=Subject Added successfully";

		}

		else {
			target = "AddSubject.jsp?status=Subject  not Added plz try again";
		}

		RequestDispatcher rd = request.getRequestDispatcher(target);
		             rd.forward(request, response);


	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		doGet(request, response);
		out.flush();
		out.close();
	}

}
