
public class JoinThread extends Thread{

	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Child: " + Thread.currentThread().getName());
		}
	}
	public static void main(String[] args)throws InterruptedException {
		JoinThread t1 = new JoinThread();
		JoinThread t2 = new JoinThread();
		JoinThread t3 = new JoinThread();
		JoinThread t4 = new JoinThread();
		JoinThread t5 = new JoinThread();
		t1.start();
	//	t1.join();
		t2.start();
		t2.join();
		for(int i = 0; i < 5; i++) {
			System.out.println("Main");
		}
		

	}

}
