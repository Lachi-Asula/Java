
public class ThreadEx1 extends Thread implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		for(int i = 0; i < 10; i++) {
			System.out.println("child  " + i );
		}
	}
	public static void main(String[] args)throws InterruptedException {
	//	Thread t = new ThreadEx1();
		Runnable r = new ThreadEx1();
		Thread t = new Thread(r);
		
		t.start();
		//t.join();
		t.suspend();
		System.out.println(Thread.currentThread().getName());
		
		for(int i = 0; i < 10; i++) {
			System.out.println("main  " + i );
		}
		t.resume();
	}

}
