package com.dts.dae.dao;


import com.dts.dae.dto.RegistrationBean;
import com.dts.core.util.DataObject;
import com.dts.core.util.LoggerManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SecurityDAO extends DataObject
{
     private Connection con;
     private boolean flag;
    public SecurityDAO() 
    {       
               con=getConnection();
    }
    
    public RegistrationBean loginCheck(RegistrationBean regbean)
    {
        String loginid=regbean.getUserID();
        String password=regbean.getPassword();
       
        RegistrationBean regbean1=new RegistrationBean();
           try
        {
            con.setAutoCommit(true);
            PreparedStatement pst=con.prepareStatement("select UTYPE,UNAME from LOGININFO where LOGINID=? and PASS=? and STATUS=1");
            pst.setString(1,loginid);
            pst.setString(2,password);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
            	regbean1.setUserType(rs.getString(1));
            	regbean1.setUserName(rs.getString(2));            
            }
            else
            {
                flag=false;
            	regbean1.setUserType("");
            	regbean1.setUserName("");    
            }
        }
        catch (SQLException ex) 
        {
        	LoggerManager.writeLogSevere(ex);
            
            flag=false;
        }
       
        return regbean1;
    }
    
    
    
    
    
}
