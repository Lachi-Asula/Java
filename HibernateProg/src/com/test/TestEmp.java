package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Employee;



public class TestEmp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee();
//		emp.setEid(444);
//		emp.setEname("sai");
//		emp.setEsal(20000);
//		emp.setEaddr("Hyd");
//		int eid = (Integer)session.save(emp);
		
		emp.setEid(333);
		emp.setEname("banala");
		emp.setEsal(1230);
		emp.setEaddr("chennai");
		session.saveOrUpdate(emp);
		tx.commit();
		System.out.println("Update Successfully");
		sf.close();
		
	}

}
