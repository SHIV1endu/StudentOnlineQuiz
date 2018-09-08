package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.dts.aoc.dto.QuestionBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;

public class QuestionAnsDao extends DataObject {
	static Connection con;
	public DbInterface db;
	private boolean flag;

	public QuestionAnsDao() {
		con = getConnection();
	}

	public boolean questionAnsDao(QuestionBean dto) {
		boolean f2 = false;
		String subjectid = dto.getSubjectid();
		String testname = dto.getTestname();
		String qid = dto.getQuestionid();
		String question = dto.getQuestion();
		String op1 = dto.getOp1();
		String op2 = dto.getOp2();
		String op3 = dto.getOp3();
		String op4 = dto.getOp4();
		String trueans = dto.getTruans();
		String addtate = dto.getAddqdate();
		try {
			con.setAutoCommit(false);
			PreparedStatement pst = null;
			int i = 0;
			pst = con
					.prepareStatement("insert into QUESTIONSET values((select nvl(max(SNO),100)+1 from QUESTIONSET),?,?,?,?,?,?,?,?,?,?)");

			pst.setString(1, subjectid);
			pst.setString(2, testname);
			pst.setString(3, qid);
			pst.setString(4, question);
			pst.setString(5, op1);
			pst.setString(6, op2);
			pst.setString(7, op3);
			pst.setString(8, op4);
			pst.setString(9, trueans);
			pst.setString(10, addtate);
			i = pst.executeUpdate();
			if (i == 1) {
				f2 = true;
				con.commit();

			} else {
				f2 = false;
				con.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f2;

	}
	public boolean storteResult(QuestionBean dto) {
		boolean f2 = false;
		String subjectid = dto.getSubjectid();
		String testname = dto.getTestname();
		
	    String userid=dto.getUserid();
	    String name=dto.getName();
	    String email=dto.getEmail();
	    String mobile=dto.getPhone();
	    
	    int mymarks=dto.getMyans();
	    int totmarks=20;
	    String sql="insert into TESTRESULTCART values((select nvl(max(SNO),100)+1 from TESTRESULTCART),?,?,?,?,?,?,?,?,?)";
		
		String trueans = dto.getTruans();
		String addtate = dto.getAddqdate();
		try {
			con.setAutoCommit(false);
			PreparedStatement pst = null;
			int i = 0;
			pst = con
					.prepareStatement(sql);
		
			pst.setString(1,userid );
			pst.setString(2,name );
			pst.setString(3,email );
			pst.setString(4,mobile );
			pst.setString(5, testname);
			pst.setString(6, subjectid);
			
			pst.setInt(7, mymarks);
			pst.setInt(8, totmarks);
			
			Date d=new Date();
			pst.setDate(9, new java.sql.Date(d.getTime()));
			i = pst.executeUpdate();
			System.out.println(sql);
			if (i == 1) {
				f2 = true;
				con.commit();

			} else {
				f2 = false;
				con.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
		
		
	}
	
	
	
}
