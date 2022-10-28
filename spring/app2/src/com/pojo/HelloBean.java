package com.pojo;

public class HelloBean {

	private String name;
		
	public String getName() {
		return name;
	}

	public void setName(String fname) {
		this.name = fname;
	}

	public void sayHello() {
		System.out.println("Hello, How r u "+ getName()+"");
	}
}
