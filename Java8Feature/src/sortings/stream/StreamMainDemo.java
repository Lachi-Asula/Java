package sortings.stream;
import sortings.java8.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMainDemo {

	public static void main(String[] args) {
		Map<Integer, Integer> freq = new HashMap<>();
		List<String> empty = new ArrayList<>();
		List<Integer> ints = Arrays.asList(1,5,1,12,7,9,11,24,41,9,20,9,11,20,5);
		List<String> names = Arrays.asList("leela", "sai", "lachi", "gopi", "kalyan", "madhu", "padma", "ashu");
		
		System.out.println("Even or Odd");
		ints.stream().filter(x -> x % 2 != 0).forEach(x -> System.out.println(x));
		
		System.out.println("Starts With");
		names.stream().filter(x -> x.startsWith("l")).forEach(x -> System.out.println(x));
		
		System.out.println("Ends With");
		names.stream().filter(x -> x.endsWith("u")).forEach(x -> System.out.println(x));
		
		System.out.println("Ascending order");
		ints.stream().sorted().forEach(x -> System.out.println(x));
		names.stream().sorted().forEach(x -> System.out.println(x));
		
		System.out.println("if Length match adding to another list");
		names.stream().filter(x -> x.length() > 4).map(x -> empty.add(x)).collect(Collectors.toList());
		empty.forEach(x -> System.out.println(x));
		
		System.out.println("Max number");
		int max = ints.stream().max(Integer::compare).get();
		System.out.println(max);
		
		System.out.println("Reverse Order");
		ints.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.println(x));
		names.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.println(x));
		
		System.out.println("Distinct elements");
		ints.stream().distinct().forEach(x -> System.out.println(x));
		
		System.out.println("Duplicates are");
		ints.stream().filter(x -> Collections.frequency(ints, x) > 1).collect(Collectors.toSet()).stream().forEach(x -> System.out.println(x));
	
		System.out.println("Frequency of numbers");
		ints.forEach(x ->freq.put(x, Collections.frequency(ints, x)));
		freq.forEach((x,y)-> System.out.println(x + " - " + y));
		
		System.out.println("Employee list sorted based on salary");
		List<Employee> emps = new Employee().getEmps();
		emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(x -> System.out.println(x));
		
		System.out.println("First repeated number in list is");
		ints.stream().filter(x -> Collections.frequency(ints, x) > 1).limit(1).forEach(x -> System.out.println(x));
	
		System.out.println("First non repeated number in list is");
		ints.stream().filter(x -> Collections.frequency(ints, x) == 1).limit(1).forEach(x -> System.out.println(x));
		
		System.out.println("Number of elements in list is: ");
		int count = (int)ints.stream().count();
		System.out.println(count);
		
		System.out.println("list of Integer Numbers starts with 1(distinct values)");
		ints.stream().map(x -> String.valueOf(x)).filter(x -> x.startsWith("1")).distinct().forEach(x -> System.out.println(x));
	}
}
