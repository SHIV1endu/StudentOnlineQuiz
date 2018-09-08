package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.dts.aoc.dto.AddSubjectDto;
import com.dts.aoc.dto.QuestionBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
import com.dts.core.util.LoggerManager;
import com.dts.dae.dto.RegistrationBean;
import com.sun.crypto.provider.HmacMD5;

public class AddSubjectdao extends DataObject {
	   static Connection con;
	    public DbInterface db;
	    private boolean flag;
	    public AddSubjectdao() 
	    {
	           con=getConnection();  
	    }
	    
	    public HashMap subjectid(){
	    	
	    	HashMap hm=new HashMap();

	    	try {
				PreparedStatement pst=null;
				int i=0;
				pst=con.prepareStatement("select *from ADDSUBJECT");
				System.out.println("connection--->"+con);
				 ResultSet rs=pst.executeQuery();
				 while(rs.next()){
                 AddSubjectDto dto=new AddSubjectDto();
                 dto.setSubjectid(rs.getString(1));
                 System.out.println("values--->"+rs.getString(1));
                 dto.setSubjectname(rs.getString(2));
                 
                 i=i+1;
                 hm.put(i, dto);
                }
				     
			} catch ( Exception e) {
				e.printStackTrace();
				
			}
			return hm;
		}
	    	
	    
	    
  public HashMap testname(){
	    	
	    	HashMap hm=new HashMap();

	    	try {
				PreparedStatement pst=null;
				int i=0;
				pst=con.prepareStatement("select * from ADDTEST where status='1'");
				System.out.println("connection--->"+con);
				 ResultSet rs=pst.executeQuery();
				 while(rs.next()){
                 AddSubjectDto dto=new AddSubjectDto();
                 dto.setSno(rs.getString(1));
                 dto.setSubjectid(rs.getString(2));
                 System.out.println("values--->"+rs.getString(1));
                 dto.setTestname(rs.getString(3));
                 dto.setTotalnoQuestion(rs.getString(4));
                 
                 i=i+1;
                 hm.put(i, dto);
                }
				     
			} catch ( Exception e) {
				e.printStackTrace();
				
			}
			return hm;
		}
	    	
	 
	    // tsting the java code for question	(incomplete)
 public HashMap checksubjecti(){
	    	
	    	HashMap hm=new HashMap();

	    	try {
				PreparedStatement pst=null;
				int i=0;
				pst=con.prepareStatement("select  TOTAL_NO_OUESTION from ADDTEST where SUBJECTID=?");
				System.out.println("connection--->"+con);
				 ResultSet rs=pst.executeQuery();
				 while(rs.next()){
                 AddSubjectDto dto=new AddSubjectDto();
                 dto.setSubjectid(rs.getString(1));
                 System.out.println("values--->"+rs.getString(1));
                 dto.setSubjectname(rs.getString(2));
                 dto.setTotalnoQuestion(rs.getString(3));
                 
                 
                 i=i+1;
                 hm.put(i, dto);
                }
				     
			} catch ( Exception e) {
				e.printStackTrace();
				
			}
			return hm;
		}	
	    
 // upt to
 
 public AddSubjectDto totalQuestion(AddSubjectDto dto){
	 
	        String testname=dto.getTestname();
	        AddSubjectDto dtototal=new AddSubjectDto();
	        try{
	        	 con.setAutoCommit(true);
	             PreparedStatement pst=con.prepareStatement("select TOTAL_NO_OUESTION , SUBJECTID ,TEST_NAME from ADDTEST where TEST_NAME=? ");
	             pst.setString(1,testname);
	            
	             
	             ResultSet rs=pst.executeQuery();
	             if(rs.next())
	             {
	            	 dtototal.setTotalnoQuestion(rs.getString(1));
	            	 dtototal.setSubjectid(rs.getString(2));
	            	 dtototal.setTestname(rs.getString(3));
	             	   
	             }
	             else
	             {
	                 flag=false;
	                 dtototal.setTotalnoQuestion("");
	             	   
	             }
	         }
	         catch (SQLException ex) 
	         {
	         	LoggerManager.writeLogSevere(ex);
	             
	             flag=false;
	         }
	        
	         return dtototal;
	     }
	     
 
	    
	    public boolean chicksubjectname(String subjectname){
	    	 boolean flag=false;
	    	  try {
                   PreparedStatement pst=null;
                   int i=0;
                   pst=con.prepareStatement("select * from ADDSUBJECT where SUBJECTNAME=?");
                   pst.setString(1, subjectname);
                   ResultSet rs=pst.executeQuery();
             while(rs.next()){
            	 flag=true;
            	 
             }
              
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	return flag;
	    	
	    	
	    	
	    	
	    }
	    
	    
	   public boolean addSubject(AddSubjectDto sub){
		   
		   String subjectname=sub.getSubjectname();
		   
		   try {
			   con.setAutoCommit(false);
	           PreparedStatement pst=null;
	           int i=0;
	          pst=con.prepareStatement("insert into ADDSUBJECT values((select nvl(max(SUBJECTID),100)+1 from ADDSUBJECT),?)");                     
	           pst.setString(1,subjectname);
	          
	             
	           i=pst.executeUpdate();
	            if(i==1)
	            {
	                flag=true;
	                con.commit();
	            }
	            else
	            {
	                flag=false;
	                con.rollback();
	            }      
	        } 
	        catch (SQLException ex) 
	        {
	            ex.printStackTrace();
	            flag=false;
	            try 
	            {
	                con.rollback();
	            } 
	            catch (SQLException sex) 
	            {
	                sex.printStackTrace();
	            }
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	            flag=false;
	            try 
	            {
	                con.rollback();
	            } 
	            catch (SQLException se) 
	            {
	                se.printStackTrace();
	            }
	        }
	        return flag;
	    }
			   
	public boolean addTest(AddSubjectDto dto){
		     String subjectid=dto.getSubjectid();
		     
		     String subjectName=dto.getSubjectname();
		     String testname=dto.getTestname();
		     String totalnoquestion=dto.getTotalnoQuestion();
		     String adddate=dto.getAaddate();
		     
		     try {
		    	 con.setAutoCommit(false);
		           PreparedStatement pst=null; 
		           int i=0;
			          pst=con.prepareStatement("insert into ADDTEST values((select nvl(max(SNO),100)+1 from ADDTEST),?,?,?,?,?)");
		    	     pst.setString(1, subjectid);
		    	     pst.setString(2, testname);
		    	     pst.setString(3, totalnoquestion);
		    	     pst.setString(4, adddate);
			         pst.setString(5, "0"); 
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
	public boolean deleteTest(AddSubjectDto dto){
	     String subjectid=dto.getSubjectid();
	     System.out.println("sub"+subjectid);
	     
	    // String subjectName=dto.getSubjectname();
	    // String testname=dto.getTestname();
	  //   String totalnoquestion=dto.getTotalnoQuestion();
	    // String adddate=dto.getAaddate();
	  
	     try {
	    	
	           PreparedStatement pst=null; 
	           PreparedStatement pst2=null; 
	           PreparedStatement pst3=null; 
	           int i=0;
	           int j=0;
	           int k=0;
	           try{
		          pst=con.prepareStatement("delete from ADDSUBJECT Where SUBJECTNAME='"+subjectid+"'");
	    	       
		          i=pst.executeUpdate();
		          System.out.println("Record is deleted====iiii"+i);
		          
		          try{
			          System.out.println("Record is deleted!"+ subjectid);
			          pst2=con.prepareStatement("delete from ADDTEST where SUBJECTID='"+subjectid+"'");
			        
			          j=pst2.executeUpdate();
			          System.out.println("Record is deleted====jjjjj"+j);
			          
			          
			          try{
			        	  pst3=con.prepareStatement("delete from QUESTIONSET Where SUBJECTID='"+subjectid+"'");
			        	  k=pst3.executeUpdate();
				          System.out.println("Record is deleted====kkkk"+k);
			        	  
			          }catch (Exception e) {
							e.printStackTrace();
			           } 
			          
		           }catch (Exception e) {
					e.printStackTrace();
		           } 
	           }catch(Exception e){
	        	   e.printStackTrace();
	           }
	           
	    	      if(i>0 ){
	    	        	    	  
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

	
	
	 public HashMap getTestName(){
	    	
	    	HashMap hm=new HashMap();

	    	try {
				PreparedStatement pst=null;
				int i=0;
				pst=con.prepareStatement("SELECT DISTINCT TESTNAME FROM QUESTIONSET");
				System.out.println("connection--->"+con);
				 ResultSet rs=pst.executeQuery();
				 while(rs.next()){
              QuestionBean dto=new QuestionBean();
              dto.setTestname(rs.getString(1));
              System.out.println("values--->"+rs.getString(1));
               i=i+1;
              hm.put(i, dto);
             }
				     
			} catch ( Exception e) {
				e.printStackTrace();
				
			}
			return hm;
		}
			
	 
	 
	 public HashMap viewAllQuestionList(String tname){
	    
	    	HashMap hm=new HashMap();

	    	try {
				PreparedStatement pst=null;
				int i=0;
				pst=con.prepareStatement("select *from QUESTIONSET where testname=? order by quesid ");
				pst.setString(1, tname);
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
		
	 
	/* public HashMap getTestNameDetailsByAdmin(){
	    	
	    	HashMap hm=new HashMap();

	    	try {
				PreparedStatement pst=null;
				int i=0;
				pst=con.prepareStatement("select *from ADDTEST");
				System.out.println("connection--->"+con);
				 ResultSet rs=pst.executeQuery();
				 while(rs.next()){
              AddSubjectDto dto=new AddSubjectDto();
              dto.setSno(rs.getString(1));
              dto.setSubjectid(rs.getString(2));
              System.out.println("values--->"+rs.getString(1));
              dto.setTestname(rs.getString(3));
              dto.setTotalnoQuestion(rs.getString(4));
              dto.setAaddate(rs.getString(5));
              
              i=i+1;
              hm.put(i, dto);
             }
				     
			} catch ( Exception e) {
				e.printStackTrace();
				
			}
			return hm;
		}
	 
	 */
		   
	   }
	


