package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
import com.dts.dae.dto.RegistrationBean;

public class NewUserAcceptance extends DataObject {
	static Connection con;
	public DbInterface db;

	private boolean flag;

	public  NewUserAcceptance() {
		con = getConnection();
	}
	
	public boolean deleteNewUserAccount(String loginid){
		
		 try {
			  
			 PreparedStatement ps=con.prepareStatement("delete LOGININFO where LOGINID='"+loginid+"'");
			 PreparedStatement ps1=con.prepareStatement("delete USERINFO where LOGINID='"+loginid+"'");
			 int i=0;
			 int i2=0;
			 i=ps.executeUpdate();
			 i2=ps1.executeUpdate();
			 if(i>0 && i2>0){
				 flag=true;
				 
			 }
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
		
		
		
	}
	public boolean rejectUser(String loginid){
		try{
			
			PreparedStatement ps=con.prepareStatement("update LOGININFO  set status=2 where LOGINID='"+loginid+"'");
			int i=0;
			i=ps.executeUpdate();
			if(i>0){
				 flag=true;
				
			}
		}
			catch (Exception e) {
				System.out.println(e);
					}
			return flag;
			
		}
		
	public boolean getAcceptNewUser(String loginid) {
		try {
			PreparedStatement ps = con
					.prepareStatement("update LOGININFO set status=1 where LOGINID='"
							+ loginid + "'");
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

	public HashMap getUser(){
	  HashMap hm=new HashMap();
	  try {
			PreparedStatement ps = con
					.prepareStatement("select * FROM LOGININFO where STATUS='0' ");
			int i = 0;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				RegistrationBean rbean = new RegistrationBean();
				rbean.setUserID(rs.getString(1));
				rbean.setUserType(rs.getString(3));
				rbean.setUserName(rs.getString(4));
				i = i + 1;
				hm.put(i, rbean);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return hm;
	}

	
	
	
	}

