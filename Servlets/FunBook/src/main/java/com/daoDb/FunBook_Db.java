package com.daoDb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.fBook.FunBook_Bean;
;
public class FunBook_Db {
	
	public Connection getConnection() {
		Connection getCon = null;
		
		try {
			getCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/lachiasula","root","Asula@143");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return getCon;
	}
	
	public boolean addUser(FunBook_Bean fb) {
		boolean b = false;
		
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into funbook(firstName,surName,gender,mobile,email,password) values(?,?,?,?,?,?)");
			pst.setString(1, fb.getFirstName());
			pst.setString(2, fb.getSurName());
			pst.setString(3, fb.getGender());
			pst.setString(4, fb.getMobile());
			pst.setString(5, fb.getEmail());
			pst.setString(6, fb.getPassword());
			
			int n = pst.executeUpdate();
			
			if(n > 0) {
				b = true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return b;
	}
	
	public boolean deleteUser(int uid) {
		boolean b = false;
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			int n = stmt.executeUpdate("delete from funbook where id="+uid+"");
			
			if(n > 0) {
				b = true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return b;
	}
	
	public boolean validUser(String em, String pass) {
		boolean b = false;
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from funBook where Email='"+em+"' and Password='"+pass+"'");
			
			while(rs.next()) {
				b = true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return b;
	}
	
	public List userList() {
		List<FunBook_Bean> li = new ArrayList();
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from funBook");
			
			while(rs.next()) {
				int uid = rs.getInt(1);
				String firstName = rs.getString(2);
				String surName = rs.getString(3);
				String gender = rs.getString(4); 
				String mobile = rs.getString(5);
				String email = rs.getString(6);
				String password = rs.getString(7);
				
				FunBook_Bean fb = new FunBook_Bean(firstName,surName,gender,mobile,email,password);
				fb.setId(uid);
				
				li.add(fb);
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return li;
	}
	
	public List editUser(int uno) {
		List<FunBook_Bean> li = new ArrayList();
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from funBook where id = "+uno+"");
			
			while(rs.next()) {
				int uid = rs.getInt(1);
				String firstName = rs.getString(2);
				String surName = rs.getString(3);
				String gender = rs.getString(4); 
				String mobile = rs.getString(5);
				String email = rs.getString(6);
				String password = rs.getString(7);
				
				FunBook_Bean fb = new FunBook_Bean(firstName,surName,gender,mobile,email,password);
				
				li.add(fb);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return li;
	}
}
