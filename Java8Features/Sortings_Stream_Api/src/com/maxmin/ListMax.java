package com.maxmin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import com.model.EmpInfo;
import com.model.Employee;

public class ListMax {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		li.add(11);
		li.add(4);
		li.add(32);
		li.add(2);
		li.add(17);
		
		System.out.println("Original List is");
		li.forEach(System.out::println);
		
		System.out.println("Max Number in Given List is");
		int max = li.stream().max(Comparator.comparingInt(Integer::valueOf)).get();
		System.out.println(max);
		
		EmpInfo emp = new EmpInfo();
		List<Employee> list = emp.getList();
		
		System.out.println("Original List is");
		list.stream().forEach(x -> System.out.println(x));
		
		System.out.println("Highest Salary Employee Info");
		Employee e = list.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(e);
		
		System.out.println("Lowest Salary Employee Info");
		Employee e1 = list.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(e1);
		
		System.out.println("Number of Employees");
		long count = list.stream().count();
		System.out.println(count);
	
	}
}
