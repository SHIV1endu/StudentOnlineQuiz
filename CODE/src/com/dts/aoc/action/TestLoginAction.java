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

import com.dts.aoc.dao.UserTestConformationDAO;
import com.dts.aoc.dto.QuestionBean;

public class TestLoginAction extends HttpServlet {
	String target = null;
	String uid12 = null;
	String phone1 = null;
	String emailid = null;
	String tpapername = null;
	String sid = null;
	String name = null;
	RequestDispatcher rd = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		QuestionBean dto = new QuestionBean();
		String userid = (String) session.getAttribute("userid");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String tnamec = request.getParameter("tnamec");
		
		
		System.out.println("userid==="+userid);
		System.out.println("email==="+email);
		System.out.println("phone==="+phone);
		System.out.println("tnamec==="+tnamec);
		
		
		
		
		
		
		
		System.out.println("Specific test papaer user---->" + tnamec);
		dto.setUserid(userid);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setTestname(tnamec);
		QuestionBean dto1 = new QuestionBean();
		dto1 = new UserTestConformationDAO().checkTestnameLogin(dto);

		tpapername = dto1.getTestname();
		
		System.out.println("testname--->" + tpapername);

		emailid = dto1.getEmail();
		System.out.println("testname--->" + emailid);
		phone = dto1.getPhone();
		System.out.println("testname--->" + phone);
		uid12 = dto1.getUserid();
		System.out.println("testname--->" + uid12);
		sid = dto1.getSubjectid();
		System.out.println("testname--->" + sid);
		name=dto1.getName();
		System.out.println("testname--->" + name);
		
		session.setAttribute("tpaper", tpapername);
		session.setAttribute("name", name);
		session.setAttribute("sid", sid);
		session.setAttribute("phone", phone);
		session.setAttribute("emailid", emailid);
		session.setAttribute("uid",uid12);
		HashMap hmv = new HashMap();

		if (tpapername.length() > 0) {
			hmv = new UserTestConformationDAO()
					.getQuestionTestPaper(tpapername);
			session.setAttribute("hmv", hmv);
			session.setAttribute("que",1);
			
			session.setAttribute("numberCorrectAnswer",0);
			session.setAttribute("numberWrongAnswer",0);
			
			rd = request.getRequestDispatcher("StartTestQuize.jsp");
			rd.forward(request, response);

		} else {
			rd = request
					.getRequestDispatcher("UserConformBeforeTest.jsp?status=Invalid email or phone number");
			rd.forward(request, response);
		}

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		doPost(request, response);

	}
	

}