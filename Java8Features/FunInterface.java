package java8;

public interface FunInterface {
 
	abstract int m1(int x, int y);
	
	default void wish() {
		System.out.println("Welcome to Java");
	}
	
	public static void wish(String name) {
		System.out.println("Welcome to " + name);
	}
}
