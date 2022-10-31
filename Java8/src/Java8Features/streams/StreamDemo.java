import java.util.*;
import java.util.stream.Collectors;
public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(li);
		
		li = li.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(li);

	}

}
