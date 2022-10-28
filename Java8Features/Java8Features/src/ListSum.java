import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListSum {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList();
		li.add(5);
		li.add(19);
		li.add(3);
		li.add(2);
		li.add(9);
		
		int sum = li.stream().mapToInt(x -> x).sum();
	//	int sum = li.stream().max(Integer::compare).get();
	//	int sum = li.stream().min(Comparator.comparingInt(Integer::valueOf)).get();
		System.out.println(sum);
			
	}

}
