package Java8Features;

public class LamdaExpr {
	FunInterface fn = (x, y) -> {
		return (x + y);
	};

	public static void main(String[] args) {
		
		System.out.println(new LamdaExpr().fn.m1(5, 6));
	}
}
