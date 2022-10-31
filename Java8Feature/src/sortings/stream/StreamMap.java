package sortings.stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

	public static void main(String[] args) {
//		int[] a = {1,2,4,2,5,8,7};
		List<Integer> li = Arrays.asList(1,2,4,5,6,7,3,2);
		
		
		li = li.stream().map(x -> x * x).sorted().filter(x->x%2==0).collect(Collectors.toList());
		li.forEach(System.out::println);
	}

}
