
public class ErrorThread extends Thread{

	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("child");
		}
	}
	public static void main(String[] args) {
		ErrorThread et = new ErrorThread();
		et.start();

		for(int i = 0; i < 10; i++) {
			System.out.println("main");
			if(i == 5) {
				System.out.println(10/0);
			}
		}
	}

}
