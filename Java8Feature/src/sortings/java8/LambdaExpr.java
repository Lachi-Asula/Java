package sortings.java8;
import java.util.Arrays;
import java.util.List;

//interface I1{
//	void add(int a, int b);
////	void sub(int a,int b);
//	static void disp() {
//		System.out.println("hello");
//	}
//}
//
//public class LambdaExpr {
//
//	public static void main(String[] args) {
//		I1 i = (a,b) -> System.out.println(a + b);
//		i.add(5, 6);
//		I1.disp();
//	}
//
//}

public class LambdaExpr{
	public static void main(String[] args) {
		int[] arr = {2,5,1,6,8,1};
		List<Integer> li = Arrays.asList(2,5,1,6,8,1);
		li.forEach(x ->{
			if(x % 2 == 0) {
			System.out.println(x);}
		});
	}
}