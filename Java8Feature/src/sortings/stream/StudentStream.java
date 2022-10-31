package sortings.stream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StudentStream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> li = new ArrayList();
		
		System.out.println("Enter 5 strings");
		for(int i = 1; i <= 5; i++) {
			li.add(sc.next());
		}
		
		Stream<String> s = li.stream();
		Stream<String> res = s.filter(x -> x.startsWith("s"));
		res.forEach(y -> System.out.println(y));
		
		List<String> sort = li.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted list is:");
		sort.forEach(x -> System.out.println(x));
		
		List<String> dist = li.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct elements are: \n" + dist);
	}

}
