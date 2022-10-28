package com.bank;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Emp{
	 
	void wish(String name);
	
	default void m1() {
		System.out.println("Default");
	}
	
	static void m2() {
		System.out.println("Static");
	}
}

public class Functional_Interface {

	Emp e = (name) -> System.out.println(name);
	
	public static void main(String[] args) {
		List<Employee> li = new ArrayList<>();
		li.add(new Employee("lakshmi", 25));
		li.add(new Employee("siva", 23));
		
		Functional_Interface fi = new Functional_Interface();
		
		li.forEach(x -> fi.e.wish(x.getName()));
	}
}

class Employee{
	private String name;
	private int age;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
