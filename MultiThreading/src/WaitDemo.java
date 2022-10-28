
public class WaitDemo extends Thread{

	public  void run() {
		synchronized(this) {
			System.out.println("child");
			notify();
		}
	}
	public static void main(String[] args)throws Exception {
		WaitDemo t1 = new WaitDemo();
		t1.start();
		synchronized(t1) {
			t1.wait();
			System.out.println("Main");
		}
	}

}
