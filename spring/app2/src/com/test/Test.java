package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.HelloBean;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/resourses/applicationContext.xml");
		HelloBean hb = (HelloBean) context.getBean("hello");
	// 	hb.setName("lachi");
		hb.sayHello();
	}

}
