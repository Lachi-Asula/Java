package sortings.list;
import sortings.model.EmpInfo;
import sortings.model.Employee;

import java.util.Comparator;
import java.util.List;


public class SortingListEmp {

	public static void main(String[] args) {
		EmpInfo emp = new EmpInfo();
		List<Employee> list = emp.getList();
		
		System.out.println("Original List");
		list.forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Sorting Based on Emp salary");
		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
	
		System.out.println();
		
		System.out.println("Sorting based on Emp salary in Descending Order");
		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("sortiing Based on Employee Name");
		list.stream().sorted(Comparator.comparing(Employee::getEname)).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Sorting Based on Employee Id");
		list.stream().sorted(Comparator.comparingInt(Employee::getEid)).forEach(System.out::println);
	}
}
