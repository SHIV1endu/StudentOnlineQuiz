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

import com.dts.aoc.dao.AddSubjectdao;
import com.dts.aoc.dto.QuestionBean;

public class ViewQuestionList extends HttpServlet {

	public boolean f = false;
	String target = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		QuestionBean dto = new QuestionBean();
		String tname = request.getParameter("testname").trim();
		System.out.println("testname" + tname);
		HttpSession session = request.getSession();
		session.setAttribute("tname", tname);
		HashMap hmv = new HashMap();
		hmv = new AddSubjectdao().viewAllQuestionList(tname);
		session.setAttribute("hmv", hmv);
		RequestDispatcher rd = request.getRequestDispatcher("ViewQueslist.jsp");
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
