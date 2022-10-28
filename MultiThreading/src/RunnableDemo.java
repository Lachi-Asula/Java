
public class RunnableDemo implements Runnable {
	public void run(){
		System.out.println("child : " + Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getName());
		for(int i = 0; i < 10 ; i++) {
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("main : " + Thread.currentThread().getPriority());
		System.out.println("main : " + Thread.currentThread().getName());
		
		Runnable  t = new  RunnableDemo();
		Thread t1 = new Thread(t);
		t1.start();
	}
}
