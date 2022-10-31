package sortings.stream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(10,21,3,4,4,5);
		li.stream().filter(x -> x % 2 == 0).map(x -> x * x).sorted().forEach(x -> System.out.println(x));
		//res.forEach(x -> System.out.println(x));
		
//		int evenSum = li.stream().filter(x -> x % 2 == 0).reduce(0, (sum, i) -> sum + i);
//		System.out.println(evenSum);
		
		System.out.println();
		Stream<Integer> s = li.stream();
		Set<Integer> st = s.map(x -> x * x).collect(Collectors.toSet());
		st.forEach(y -> System.out.println(y));
	}

}
