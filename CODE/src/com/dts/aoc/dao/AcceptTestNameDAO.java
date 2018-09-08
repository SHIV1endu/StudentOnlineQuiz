package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.dts.aoc.dto.AddSubjectDto;
import com.dts.aoc.dto.QuestionBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;

public class AcceptTestNameDAO extends DataObject {
	static Connection con;
	public DbInterface db;
	private boolean flag;

	public AcceptTestNameDAO() {
		con = getConnection();
	}

	public HashMap getTestNameDetailsByAdmin() {

		HashMap hm = new HashMap();

		try {
			PreparedStatement pst = null;
			int i = 0;
			pst = con.prepareStatement("select *from ADDTEST where status='0'");
			System.out.println("connection--->" + con);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				AddSubjectDto dto = new AddSubjectDto();
				dto.setSno(rs.getString(1));
				dto.setSubjectid(rs.getString(2));
				System.out.println("values--->" + rs.getString(1));
				dto.setTestname(rs.getString(3));
				dto.setTotalnoQuestion(rs.getString(4));
				dto.setAaddate(rs.getString(5));

				i = i + 1;
				hm.put(i, dto);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return hm;
	}

	public HashMap getTestNameDetails() {

		HashMap hm = new HashMap();

		try {
			PreparedStatement pst = null;
			int i = 0;
			pst = con.prepareStatement("select *from ADDTEST where status='1'");
			System.out.println("connection--->" + con);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				AddSubjectDto dto = new AddSubjectDto();
				dto.setSno(rs.getString(1));
				dto.setSubjectid(rs.getString(2));
				System.out.println("values--->" + rs.getString(1));
				dto.setTestname(rs.getString(3));
				dto.setTotalnoQuestion(rs.getString(4));
				dto.setAaddate(rs.getString(5));

				i = i + 1;
				hm.put(i, dto);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return hm;
	}

	public boolean getAcceptTestName(String tsno) {
		try {
			System.out.println("tno" + tsno);
			PreparedStatement ps = con
					.prepareStatement("update ADDTEST set status='1' where SNO='"
							+ tsno.trim() + "'");
			int i = 0;
			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	

	public boolean deleteTestName(String tsno) {

		try {

			PreparedStatement ps = con
			.prepareStatement("update ADDTEST set status='3' where SNO='"
					+ tsno.trim() + "'");

			int i = 0;

			i = ps.executeUpdate();

			if (i == 1) {
				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;

	}

	public boolean rejectTestName(String tsno) {
		try {
			System.out.println("tno" + tsno);

			PreparedStatement ps = con
			.prepareStatement("update ADDTEST set status='2' where SNO='"
					+ tsno.trim() + "'");
			int i = 0;
			i = ps.executeUpdate();
			if (i ==1) {
				flag = true;
				con.commit();

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;

	}
	public boolean DeleteTest(String tsno) {
		
			  try {
			    	
		           PreparedStatement pst=null; 
		           PreparedStatement pst2=null; 
		           PreparedStatement pst3=null; 
		           int i=0;
		           int j=0;
		           
		          System.out.println(tsno);
			          try{
				          System.out.println("Record is deleted!"+ tsno);
				          pst2=con.prepareStatement("delete from ADDTEST where TEST_NAME='"+tsno+"'");
				        
				          j=pst2.executeUpdate();
				          System.out.println("Record is deleted====jjjjj"+j);
				          
				          
				          try{
				        	  pst3=con.prepareStatement("delete from QUESTIONSET Where TESTNAME='"+tsno+"'");
				        	  i=pst3.executeUpdate();
					          System.out.println("Record is deleted====iiii"+i);
				        	  
				          }catch (Exception e) {
								e.printStackTrace();
				           } 
				          
			           }catch (Exception e) {
						e.printStackTrace();
			           } 
		           
		           
		    	      if(j>0 ||i>0){
		    	        	    	  
		    	  flag=true;
		    	    	  con.commit();
		    	    	  
		    	      }
		    	      else{
		    	    	  
		    	    	  flag=false;
		    	    	  con.rollback();
		    	    	  
		    	    	  
		    	      }
				
			} catch (Exception e) {
			e.printStackTrace();	
			}
		     
		return flag;
		

	}

	
	
	public HashMap ViewUserTestInformation() {

		HashMap hm = new HashMap();

		try {
			PreparedStatement pst = null;
			int i = 0;
			pst = con.prepareStatement("SELECT DISTINCT  TESTNAME , SUBJECTID FROM QUESTIONSET");
			System.out.println("connection--->" + con);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				AddSubjectDto dto = new AddSubjectDto();
				dto.setTestname(rs.getString(1));
				dto.setSubjectid(rs.getString(2));
				System.out.println("values--->" + rs.getString(1));
				
				i = i + 1;
				hm.put(i, dto);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return hm;
	}
	
	public HashMap getResult(String from,String to)throws Exception
	{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate=sd.parse(from);
		Date toDate=sd.parse(to);
		HashMap hmpro = new HashMap();
String sql="SELECT * from  TESTRESULTCART where examdate>=? and examdate<=?";

		try {
			PreparedStatement pst = null;
			int i = 0;
			pst = con.prepareStatement(sql);
			pst.setDate(1, new java.sql.Date(fromDate.getTime()));
			pst.setDate(2, new java.sql.Date(toDate.getTime()));
			System.out.println("connection--->" + con);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				System.out.println(sql);
				QuestionBean fto=new QuestionBean();
				fto.setSno(rs.getString(1));
				fto.setUserid(rs.getString(2));
				fto.setName(rs.getString(3));
				fto.setEmail(rs.getString(4));
				fto.setPhone(rs.getString(5 ));
				fto.setTestname(rs.getString(6));
				fto.setSubjectid(rs.getString(7));
				fto.setMyans(rs.getInt(8));
				fto.setTotmarks(rs.getInt(9));
				System.out.println("values--->" + rs.getString(1));
				
				i = i + 1;
				hmpro.put(i, fto);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return hmpro;
	}
		
	
	
	
	
		}
