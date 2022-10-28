package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epaper.Epaper_Bean;
import com.users.User_Bean;

public class EpaperDb {
	
	public Connection getConn() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
			System.out.println("connected " + con);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	public boolean validAdmin(int aid, String passwd) {
		boolean b = false;
		
		try {
			Connection con = getConn();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *from admin where id = "+aid+" and password='"+passwd+"'");
			while(rs.next()) {
				b = true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return b;
	}
	
	public boolean validUser(String email, String passwd) {
		boolean b = false;
		
		try {
			Connection con = getConn();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *from users where emailid = '"+email+"' and password='"+passwd+"'");
			while(rs.next()) {
				b = true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return b;
	}
	
	public String getUserName(String em, String pass) {
		String fname = "";
		
		try {
			Connection con = getConn();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select firstname,surname from users where emailid='"+em+"' and password='"+pass+"'");
			
			while(rs.next()) {
				fname += rs.getString(1) + " " + rs.getString(2);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return fname;
	}
	
	public boolean addUser(User_Bean ub) {
		boolean b = false;
		
		try {
			Connection con = getConn();
			String firstName = ub.getFirstName();
			String surName = ub.getsurName();
			String gender = ub.getGender();
			String mobile = ub.getMobile();
			String email = ub.getEmail();
			String password = ub.getPassword();
			
			PreparedStatement pst = con.prepareStatement("insert into users(firstName,surName,gender,mobile,emailid,password) values(?,?,?,?,?,?)");
			pst.setString(1, firstName);
			pst.setString(2, surName);
			pst.setString(3, gender);
			pst.setString(4, mobile);
			pst.setString(5, email);
			pst.setString(6, password);
			
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
	
	public boolean addQuestion(Epaper_Bean eb) {
		boolean b = false;
		
		try {
			Connection con = getConn();
			PreparedStatement pst = con.prepareStatement("insert into Epaper values(?,?,?,?,?,?,?)");
			pst.setInt(1, eb.getQno());
			pst.setString(2, eb.getQname());
			pst.setString(3, eb.getOpt1());
			pst.setString(4, eb.getOpt2());
			pst.setString(5, eb.getOpt3());
			pst.setString(6, eb.getOpt4());
			pst.setString(7, eb.getAns());
			
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
	
	public List<Epaper_Bean> listQuestions(){
		List<Epaper_Bean> li = new ArrayList<Epaper_Bean>();
		Epaper_Bean eb = null;
		try {
			Connection con = getConn();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Epaper");
			while(rs.next()) {
			int qno = rs.getInt(1);
			String qname = rs.getString(2);
			String opt1 = rs.getString(3);
			String opt2 = rs.getString(4);
			String opt3 = rs.getString(5);
			String opt4 = rs.getString(6);
			String ans = rs.getString(7);
			
			eb = new Epaper_Bean(qname,opt1,opt2,opt3,opt4,ans);
			eb.setQno(qno);
			li.add(eb);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return li;
	}
	
	public boolean deleteQuestion(int id) {
		boolean b = false;
		try {
			Connection con = getConn();
			PreparedStatement pst = con.prepareStatement("delete from Epaper where qno= "+ id +"");
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
}
