class A extends Thread{
	public void run() {
		Thread.currentThread().yield();
		System.out.println("class- A");
		for(int i = 0; i < 5; i++) {
			System.out.println("A");
		}
	}
}

class B extends Thread{
	public void run() {
		System.out.println("class- B");
		for(int i = 0; i < 5; i++) {
			System.out.println("B");
		}
	}
}

class C extends Thread{
	public void run() {
		System.out.println("class- C");
		for(int i = 0; i < 5; i++) {
			System.out.println("C");
		}
	}
}

public class MultiThreadsDemo {

	public static void main(String[] args) {
		A t1 = new A();
		B t2 = new B();
		C t3 = new C();
		
		t1.setPriority(4);
		t2.setPriority(8);
		t3.setPriority(10);
		
		t1.start();
		
		t2.start();
		t3.start();
		
		System.out.println("Main Completed");

	}

}
