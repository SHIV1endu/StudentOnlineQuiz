package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import oracle.net.resolver.TNSNamesNamingAdapter;

import com.dts.aoc.dto.AddSubjectDto;
import com.dts.aoc.dto.QuestionBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
import com.dts.core.util.LoggerManager;

public class UserTestConformationDAO extends DataObject {
	   static Connection con;
	    public DbInterface db;
	    private boolean flag;
	    public UserTestConformationDAO() 
	    {
	           con=getConnection();  
	    }
	     public boolean chickconformusertest(String userid , String testname){
	    	 boolean flag=false;
	    	  System.out.println("userid--->"+userid);
	    	  System.out.println("--->"+testname);
	    	  try {
                  PreparedStatement pst=null;
                  int i=0;
                  pst=con.prepareStatement("select userid from  USERCONFORMTEST where userid=? and tname=?");
                  pst.setString(1, userid);
                  pst.setString(2, testname);
                  ResultSet rs=pst.executeQuery();
            while(rs.next()){
           	 flag=true;
           	 
            }
             
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	return flag;
	    	
	    }
	    
	     public boolean userConformTestDao(QuestionBean dto){
	     String subjectid=dto.getSubjectid();
	     
	    String userid=dto.getUserid();
	     String testname=dto.getTestname();
	    String subjid=dto.getSubjectid();
	     String email=dto.getEmail();
	     String phone=dto.getPhone();
	     String regdate=dto.getRegdate();
	     String name=dto.getName();
	        try {
	    	 con.setAutoCommit(false);
	           PreparedStatement pst=null; 
	           int i=0;
		          pst=con.prepareStatement("insert into USERCONFORMTEST values((select nvl(max(SNO),100)+1 from USERCONFORMTEST),?,?,?,?,?,?,?)");
	    	     pst.setString(1, userid);
	    	     pst.setString(2, name);
	    	     pst.setString(3, testname);
	    	     pst.setString(4, subjid);
		         pst.setString(5, email); 
		         pst.setString(6, phone); 
		         pst.setString(7, regdate); 
		          i=pst.executeUpdate();
	    	      if(i>0){
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


public QuestionBean checkTestnameLogin (QuestionBean bean){
	String userid=bean.getUserid();
	String email=bean.getEmail();
	String phone=bean.getPhone();
	String testname=bean.getTestname();
	
	
	System.out.println("userid==="+userid);
	System.out.println("email==="+email);
	System.out.println("phone==="+phone);
	System.out.println("tnamec==="+testname);
	
	
	
	System.out.println("dao----testname-->"+testname);
	QuestionBean bean1=new QuestionBean();
	try {
		PreparedStatement pst=null;
		 pst=con.prepareStatement("select USERID , name , tname , subjectid , email , mob from USERCONFORMTEST where USERID=? and EMAIL=? and MOB=? and TNAME=?");
		 pst.setString(1, userid);
		 pst.setString(2, email);
		 pst.setString(3,phone);
		 pst.setString(4, testname);
		 ResultSet rs=pst.executeQuery();
		 if(rs.next()){
			 bean1.setUserid(rs.getString(1));
			 bean1.setName(rs.getString(2));
			 bean1.setTestname(rs.getString(3));
			 bean1.setSubjectid(rs.getString(4));
		     bean1.setEmail(rs.getString(5));
		     bean1.setPhone(rs.getString(6));
			 
		 }
		 else{
			 
			 bean1.setUserid("");
			 bean1.setEmail("");
			 bean1.setPhone("");
			 bean1.setName("");
			 bean1.setTestname("");
			 bean1.setSubjectid("");
			 
			 
			 
		 }
		
	} catch (Exception e) {
		LoggerManager.writeLogSevere(e);
        
        flag=false;
	}
	     
	return bean1;
	
}	    	 
	    	 
public HashMap getQuestionTestPaper(String testnamepaper){
	
	HashMap hm=new HashMap();

	try {
		PreparedStatement pst=null;
		int i=0;
		pst=con.prepareStatement("select *from QUESTIONSET where testname=? order by SNO ");
		pst.setString(1, testnamepaper);
		System.out.println("connection--->"+con);
		 ResultSet rs=pst.executeQuery();
		 while(rs.next()){
		QuestionBean dto=new QuestionBean();
        dto.setSubjectid(rs.getString(1));
        dto.setSubjectid(rs.getString(2));
        dto.setTestname(rs.getString(3));
        dto.setQuestionid(rs.getString(4));
        dto.setQuestion(rs.getString(5));
        dto.setOp1(rs.getString(6));
        dto.setOp2(rs.getString(7));
        dto.setOp3(rs.getString(8));
        dto.setOp4(rs.getString(9));
        dto.setTruans(rs.getString(10));
        dto.setAddqdate(rs.getString(11));
          i=i+1;
      hm.put(i, dto);
     }
		     
	} catch ( Exception e) {
		e.printStackTrace();
		
	}
	return hm;
}



}
