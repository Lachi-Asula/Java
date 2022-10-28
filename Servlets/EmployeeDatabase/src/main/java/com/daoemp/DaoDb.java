package com.daoemp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.emp.Employee;

public class DaoDb {
	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
			System.out.println("Connection Successful");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	public boolean addEmployee(Employee emp) {
		boolean str = false;
		
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into emp(ename,salary,address,email,password) values(?,?,?,?,?)");
			pst.setString(1, emp.getEname());
			pst.setFloat(2, emp.getSalary());
			pst.setString(3, emp.getAddress());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPassword());
			
			int n = pst.executeUpdate();
			
			if(n > 0) {
				str = true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return str;
	}
	
	public boolean deleteEmployee(int eid) {
		boolean b = false;
		
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from emp where eno=?");
			pst.setInt(1, eid);
			
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
	
	public boolean validateUser(String em, String pass) {
		boolean b = false;
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *from emp where email='"+em+"' and password='"+pass+"'");
			
			while(rs.next()) {
				b = true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return b;
	}
	
	public List listEmp() {
		List<Employee> li = new ArrayList();
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *from emp");
			
			while(rs.next()) {
				int eno = rs.getInt(1);
				String ename = rs.getString(2);
				float salary = rs.getFloat(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String password = rs.getString(6);
				
				Employee e = new Employee(ename,salary,address,email,password);
				e.setEno(eno);
				
				li.add(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return li;
	}
}
