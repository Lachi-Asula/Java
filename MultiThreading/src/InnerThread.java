
public class InnerThread {

	static class MyThread1 extends Thread{
		public void run() {
			System.out.println("Inner Thread");
		}
	}
	
	static class MyThread2 implements Runnable{
		public void run() {
			System.out.println("Inner Runnable");
		}
	}
	
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		t1.start();
		
		MyThread2 t3 = new MyThread2();
		Thread t = new Thread(t3);
		t.start();
		
		Thread t2 = new Thread(new MyThread2());
		t2.start();

	}

}
