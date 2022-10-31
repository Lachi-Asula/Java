package sortings.java8;
import java.util.Arrays;
import java.util.List;
@FunctionalInterface
interface I1{
	void add(int a, int b);
//	void sub(int a,int b);

	default void m1() {
		System.out.println("Default");
	}

	static void disp() {
		System.out.println("hello");
	}
}

public class LambdaExpr implements I1{
	public void add(int a, int b){
		System.out.println(a + b);
	}

	I1 i1 = (a, b) ->{
		System.out.println("Outside Main: " + (a + b));
	};

	public static void main(String[] args) {
		//using method
		new LambdaExpr().add(4, 7);

		//using Lambda inside main
		I1 i = (a, b)->{
			System.out.println("Total: " + (a + b));
		};
		i.add(4,9);

		//using Lambda outside main
		new LambdaExpr().i1.add(10,3);

		//default
		new LambdaExpr().m1();

		//static
		I1.disp();
	}

}

//public class LambdaExpr{
//	public static void main(String[] args) {
//		int[] arr = {2,5,1,6,8,1};
//		List<Integer> li = Arrays.asList(2,5,1,6,8,1);
//		li.forEach(x ->{
//			if(x % 2 == 0) {
//			System.out.println(x);}
//		});
//	}
//}