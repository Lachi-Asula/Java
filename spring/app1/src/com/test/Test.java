package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Student;

public class Test {

	public static void main(String[] args)throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/resourses/applicationContext.xml");
		Student std = (Student) context.getBean("stud");
		std.display();
	}

}
