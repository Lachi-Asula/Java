package sortings.java8;
import java.util.Random;
import java.util.Scanner;

public class RandomNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
//		for(int i = 1; i <= 5; i++) {
//			System.out.println(r.nextInt(50));
//		}
		r.ints(100, 200).limit(5).forEach(x -> System.out.println(x));
		r.ints(5, 1, 50).sorted().forEach(System.out::println);
		
	}
}
