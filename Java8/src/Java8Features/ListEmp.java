package Java8Features;

import Java8Features.Emp_Bean;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListEmp {

	public static void main(String[] args) {
		List<Emp_Bean> li = new ArrayList();
		Emp_Bean emp;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many emp detailes want to enter: ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			System.out.println("Enter " + (i + 1) + " employee detailes(eid,ename,status,sal)");
			emp = new Emp_Bean(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
			li.add(emp);
		}
		
		Emp_Bean e = li.stream().max(Comparator.comparing(Emp_Bean::getEname)).get();
		//li.forEach(System.out::println);
		System.out.println(e);
	}

}
