package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.aoc.dao.AddSubjectdao;
import com.dts.aoc.dto.AddSubjectDto;

public class AddTestAction extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       String target=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AddSubjectDto dto=new AddSubjectDto();
		String subjectid=request.getParameter("subjecttestid");
		String testName=request.getParameter("testname");
		String totalQuestion=request.getParameter("totalnoQuestion");
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String DateToStr = format.format(curDate);
		System.out.println(DateToStr);
		dto.setSubjectid(subjectid);
		dto.setTestname(testName);
		dto.setTotalnoQuestion(totalQuestion);
		dto.setAaddate(DateToStr);
		boolean f=new AddSubjectdao().addTest(dto);
		if(f==true){
			
			target="AddTest.jsp?status=TestAdded Successfully";
			
		}else{
			target="AddTest.jsp?status=TestAdd failed plz try again";
			
			
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
