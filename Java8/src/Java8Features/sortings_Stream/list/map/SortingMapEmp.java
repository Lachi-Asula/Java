package Java8Features.sortings_Stream.list.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.model.Employee;

public class SortingMapEmp {

	public static void main(String[] args) {
		Map<Integer, Employee> map = new HashMap<>();
		
		map.put(1, new Employee(11,"lachi",12000,"9492096265"));
		map.put(4, new Employee(12,"ameer",2300,"9433545456"));
		map.put(2, new Employee(13,"leela",29000,"9656434343"));
		map.put(5, new Employee(14,"gopi",300,"9432322425"));
		map.put(3, new Employee(15,"siva",12500,"9867236722"));
		
		List<Entry<Integer, Employee>> list = new ArrayList<>(map.entrySet());
		
		System.out.println("Original Info");
		list.forEach(System.out::println);
		
		System.out.println("Sorting based on key");
		list.stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
		
		System.out.println("Sorting Based on Emp Salary");
		list.stream().sorted(Entry.comparingByValue(Comparator.comparingDouble(Employee::getSalary))).forEach(System.out::println);
		
		System.out.println("Sorting Based on Emp Name");
		list.stream().sorted(Entry.comparingByValue(Comparator.comparing(Employee::getEname))).forEach(System.out::println);
		
		System.out.println("Sorting Based on Emp Id");
		list.stream().sorted(Entry.comparingByValue(Comparator.comparingInt(Employee::getEid))).forEach(x -> System.out.println(x));
	}
}
