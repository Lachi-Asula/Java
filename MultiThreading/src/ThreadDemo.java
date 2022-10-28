
public class ThreadDemo extends Thread{

	
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Child" + i);
		}
		
	}
	
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		td.setPriority(10);
		td.start();
		
		for(int i = 0; i < 10; i++) {
			System.out.println("main" + i);
		}

	}

}
