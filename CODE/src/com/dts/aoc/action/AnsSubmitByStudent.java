package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dts.aoc.dao.QuestionAnsDao;

import com.dts.aoc.dto.QuestionBean;

public class AnsSubmitByStudent extends HttpServlet {

	String answer = "";
	String qidanswer = "";
	String Trueans = "";
	int t = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		QuestionBean dto = new QuestionBean();
		HttpSession session=request.getSession(false);
		String userid=request.getParameter("userid");
		
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String name=request.getParameter("uname");
		String testname=request.getParameter("tname");
		String subjectid=request.getParameter("sid");
		dto.setUserid(userid);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setTestname(testname);
		dto.setSubjectid(subjectid);
		
		
		
		session.setAttribute("userid", userid);
		session.setAttribute("email", email);
		session.setAttribute("name", name);
		session.setAttribute("phone", phone);
		session.setAttribute("testname", testname);
		session.setAttribute("subjectid", subjectid);
		session.setAttribute("userid", userid);
		
		
		
		System.out.print(userid+" "+name+"         "+phone+"   "+email+""+testname+""+subjectid);
		String studentAnswer[] = new String[20];
		String correctAnswer[] = new String[20];
		String questionID[] = new String[20];
		

		int numberCorrectAnswer = (Integer)session.getAttribute("numberCorrectAnswer");
		int numberWrongAnswer = (Integer)session.getAttribute("numberWrongAnswer");
		int i=(Integer)session.getAttribute("i");
		
			qidanswer = request.getParameter("qid");
			answer = request.getParameter("op");
			Trueans = request.getParameter("tue");
			System.out.println("Qid : " + qidanswer + "   Studentans: "
					+ answer + "   Tureans: " + Trueans);

			if (answer != null) {
				qidanswer = qidanswer.trim();
				answer = answer.trim();
				Trueans = Trueans.trim();
				

				if (Trueans.equalsIgnoreCase(answer)) {
					numberCorrectAnswer = numberCorrectAnswer + 1;
				} else {
					numberWrongAnswer = numberWrongAnswer + 1;
				}

			}
		

		session.setAttribute("snas"+i, answer);
		session.setAttribute("cansad"+i, Trueans);
		session.setAttribute("quid"+i, qidanswer);
		session.setAttribute("ncorrectans", numberCorrectAnswer);
		session.setAttribute("wnumberofans", numberWrongAnswer);
		
		session.setAttribute("numberCorrectAnswer", numberCorrectAnswer);
		session.setAttribute("numberWrongAnswer", numberWrongAnswer);
		 
		dto.setMyans(numberCorrectAnswer);
		
		
		session.setAttribute("que", i+1);
		
		
		
		String path="StartTestQuize.jsp";
		if(i==20)
		{
			new QuestionAnsDao().storteResult(dto);
			path="FinalResultByStudent.jsp";
		}
		
         RequestDispatcher rd=request.getRequestDispatcher(path);
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
