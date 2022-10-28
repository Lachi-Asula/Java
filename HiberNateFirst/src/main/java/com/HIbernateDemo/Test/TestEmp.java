package com.HIbernateDemo.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.HIbernateDemo.pojo.Employee;

public class TestEmp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEmpId(111);
		emp.setEmpName("lachi");
		emp.seteSalary(2000);
		emp.setEmpAddr("Guntur");
		
		session.save(emp);
		tx.commit();
		System.out.println("Connected Successfully");
		System.out.println("Inserted");
		
		sf.close();
	}

}
