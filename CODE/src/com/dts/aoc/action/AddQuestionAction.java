package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.AddSubjectdao;
import com.dts.aoc.dto.AddSubjectDto;

public class AddQuestionAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String totalno=null;
String subjetid=null;
String testname1=null;
String target=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		
		AddSubjectDto dto=new AddSubjectDto();
		 String testname=request.getParameter("testname");
		   dto.setTestname(testname);
		   AddSubjectDto dtotot=new AddSubjectDto();
		   dtotot=new AddSubjectdao().totalQuestion(dto);
		  totalno=dtotot.getTotalnoQuestion();
		  subjetid=dtotot.getSubjectid();
		  testname1=dtotot.getTestname();
		  
		  
		  session.setAttribute("totalqno", totalno);
		  session.setAttribute("subjectid", subjetid);
		  session.setAttribute("tname", testname1);
		  if(totalno!=null){
			  target="EntryQuestion.jsp?status=Welcome to Insert Question"+totalno;
			  
			  
		  }
		 RequestDispatcher rd=request.getRequestDispatcher(target);
		 rd.forward(request, response);
		out.flush();
		out.close();
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
