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

public class DeleteTestAction extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       String target=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AddSubjectDto dto=new AddSubjectDto();
		String subjectid=request.getParameter("subjecttestid");
		
		
		//Date curDate = new Date();
	//	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	//	String DateToStr = format.format(curDate);
	//	System.out.println(DateToStr);
		dto.setSubjectid(subjectid);
	
	
	//	dto.setAaddate(DateToStr);
		boolean f1=new AddSubjectdao().deleteTest(dto);
		if(f1==true){
			
			target="ViewTest.jsp?status=subject and related tests deleted Successfully";
			
		}else{
			target="ViewTest.jsp?status=delation failed plz try again";
			
			
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
