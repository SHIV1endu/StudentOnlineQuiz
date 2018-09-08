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
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.UserTestConformationDAO;
import com.dts.aoc.dto.QuestionBean;

public class UserRegisterBeforeTeststartAction extends HttpServlet {

	String target =null;
	boolean f=false;
	boolean f2=false;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		QuestionBean dto=new QuestionBean();
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		System.out.println("user id---------------->"+userid);
		String testname=request.getParameter("testname");
		System.out.println("testname---->s------->"+testname);
		String subjectid=request.getParameter("subjectid");
		System.out.println("subject ---->s------->"+subjectid);
		String name=request.getParameter("cname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String DateToStr = format.format(curDate);
		dto.setUserid(userid);
		dto.setTestname(testname.trim());
		dto.setSubjectid(subjectid.trim());
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setRegdate(DateToStr);
		target="UserRegisterBeforeTeststart.jsp?status=Sorry plz try again ";
		f2=new UserTestConformationDAO().chickconformusertest(userid ,testname);
		if(f2==true){
			target="UserRegisterBeforeTeststart.jsp?status=Sorry already exist this userid";
			
		}
		else{
			f=new UserTestConformationDAO().userConformTestDao(dto);
			if(f==true){
				target="UserConformBeforeTest.jsp?status=welcome "+name;	
				
				
			}
			
			else{
				
				target="UserRegisterBeforeTeststart.jsp?status=Sorry plz try again ";
				
			}
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
