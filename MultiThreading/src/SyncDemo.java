
public class SyncDemo extends Thread{
	public void run() {
		for(int i = 0; i < 5;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		SyncDemo t1 = new SyncDemo();
		SyncDemo t2 = new SyncDemo();
		t1.start();
		t2.start();
		
		for(int i = 0; i < 5;i++) {
			System.out.println(Thread.currentThread().getName());
		}

	}

}
