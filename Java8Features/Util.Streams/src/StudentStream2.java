import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StudentStream2 {

	public static void main(String[] args) {
		Student std1 = new Student(1,"lachi","guntur");
		Student std2 = new Student(21,"shubham","Karnataka");
		Student std3 = new Student(7,"gopi","hyd");
		Student std4 = new Student(3,"leela","sap");
		
		Set<Student> s = new HashSet();
		
//		s.add(std1);
//		s.add(std2);
//		s.add(std3);
//		s.add(std4);
		
		List<Student> li = new ArrayList();
		li.add(std1);
		li.add(std2);
		li.add(std3);
		li.add(std4);
		
		s.addAll(li);
		List<Student> li2 = new ArrayList(s);
//		Collections.sort(li, new Comparator(){
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				Student s1 = (Student)o1;
//				Student s2 = (Student)o2;
//				return s1.getSno() - s2.getSno();
//			}
//			
//		});
		
		s.forEach(System.out::println);
		li2 = li.stream().sorted(Comparator.comparing(Student::getSname)).collect(Collectors.toList());
	//	li = li.stream().sorted(Comparator.comparingInt(Student::getSno)).collect(Collectors.toList());
		li2.forEach(x -> System.out.println(x));
	}

}
