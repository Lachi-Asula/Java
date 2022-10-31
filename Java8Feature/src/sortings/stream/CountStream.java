package sortings.stream;
import java.util.*;

public class CountStream {

	public static void main(String[] args) {
		List<String> li = Arrays.asList("lachi", "siva", "gani", "raji", "sai", "sandhya");
		
		long count = li.stream().filter(x -> x.startsWith("s")).count();
		
		System.out.println(count);

	}

}
