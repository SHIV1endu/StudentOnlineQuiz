/*
 * ProfileDAO.java
 *
 * 
 * 
 */

package com.dts.dae.dao;

import com.dts.dae.dto.RegistrationBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;

import java.beans.Statement;
import java.sql.*;
import java.util.Vector;




public class ProfileDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    public ProfileDAO() 
    {
           con=getConnection();  
    }
    
    
    public boolean checkLoginIDExisted(String loginid) {
		boolean f=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * FROM LOGININFO Where LOGINID=?");
			ps.setString(1, loginid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				f=true;
		}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return f;
		}
    public boolean insertLoginInfo(RegistrationBean reb)
    {
    	 	 String uid=reb.getUserID();
    		 String pass=reb.getPassword();
    		 String uname=reb.getUserName();
    		 String utype=reb.getUserType();
        try 
        {
           con.setAutoCommit(false);
           PreparedStatement pst=null;
           int i=0;
          pst=con.prepareStatement("insert into LOGININFO values(?,?,?,?,?)");                        
           pst.setString(1,uid);
           pst.setString(2,pass);
           pst.setString(3,utype);
           pst.setString(4,uname);
           pst.setString(5, "0");
         
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
    public boolean insertUserInfo(RegistrationBean reb)
    {
    	 	 String uid=reb.getUserID();
    		 String uname=reb.getUserName();
    		 String email=reb.getUserEmail();
    		 String mob=reb.getUserMobile();
    		 String dob=reb.getUserDOB();
    		 String gender=reb.getUserGender();
    		 String uaddress=reb.getUserAddress();
        try 
        {
           con.setAutoCommit(false);
           PreparedStatement pst=null;
           int i=0;
          pst=con.prepareStatement("insert into USERINFO values(?,?,?,?,?,?,?)");                        
           pst.setString(1,uid);
           pst.setString(2,uname);
           pst.setString(3,email);
           pst.setString(4,mob);
           pst.setString(5,dob);
           pst.setString(6,gender);
           pst.setString(7,uaddress);    
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
    /////////////////////////////////////
    
    public boolean changePassword(RegistrationBean reb)
    {
    	 	 String uid=reb.getUserID();
    		 String pass=reb.getPassword();
    		 String oldpass=reb.getOldPassword();
    		 
      
        
        try 
        {
           con.setAutoCommit(false);

           int i;
           String q="Update LOGININFO set PASS='"+pass+"' where LOGINID='"+uid+"' and PASS='"+oldpass+"'";
           System.out.println(q);
           
           i=con.createStatement().executeUpdate(q);
        
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
   
    }
