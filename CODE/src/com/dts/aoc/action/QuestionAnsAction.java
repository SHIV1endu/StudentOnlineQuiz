package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.QuestionAnsDao;
import com.dts.aoc.dto.QuestionBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class QuestionAnsAction extends HttpServlet {

	boolean f1 = false;
	boolean tf = false;
	String target = null;
	int n = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		QuestionBean dto = new QuestionBean();
		String subjectid = request.getParameter("subjectid");
		String testname = request.getParameter("testname");
		System.out.println("testname servlet="+testname);
		String question = request.getParameter("Question");
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op3 = request.getParameter("op3");
		String op4 = request.getParameter("op4");
		String tans = request.getParameter("tans");

		String num = request.getParameter("qsno");

		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String DateToStr = format.format(curDate);
		dto.setSubjectid(subjectid);
		dto.setTestname(testname);
		dto.setQuestion(question);
		dto.setOp1(op1);
		dto.setOp2(op2);
		dto.setOp3(op3);
		dto.setOp4(op4);
		dto.setAddqdate(DateToStr);
		dto.setTruans(tans);
		dto.setQuestionid(num);
		n = Integer.parseInt(num.trim());
		if (n <=20) {
			f1 = new QuestionAnsDao().questionAnsDao(dto);
			n = n + 1;
			session.setAttribute("num", n);
				if (f1 == true) {
				target = "EntryQuestion.jsp?status=plz Enter continue  " + num;
				
			     }
			
		}
		else {
			target = "EntryQuestion.jsp?status=Sorry you have Enter 20 Question";
		}
			
				
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		doGet(request, response);

	}

}
