package sortings.java8;
interface MReference {
	void m1();
}

public class MethodReference{
	public static void m1() {
		System.out.println("Static Method");
	}
	public void m2() {
		System.out.println("Non static method");
	}
	
	public static void main(String[] args) {
		MReference mr = MethodReference::m1;
		mr.m1();
		
		MReference mr1 = new MethodReference()::m2;
		mr1.m1();
	}
	
	
}
