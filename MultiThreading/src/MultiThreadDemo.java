
public class MultiThreadDemo extends Thread {

	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("child " + Thread.currentThread().getName());
			
		}
	}
	public static void main(String[] args)throws InterruptedException {
		MultiThreadDemo t1 = new MultiThreadDemo();
		MultiThreadDemo t2 = new MultiThreadDemo();
		MultiThreadDemo t3 = new MultiThreadDemo();
		t1.setPriority(1);
		t2.setPriority(3);
		t3.setPriority(6);
		Thread.currentThread().setPriority(10);
		t1.start();
		t2.start();
		t3.start();
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Main");
		}
		
	}

}
