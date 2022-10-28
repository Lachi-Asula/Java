
public class Test1 extends Thread{

	public void run(){
		System.out.println(Thread.currentThread().getPriority());
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
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getName());
		
		//Test1  t1 = new  Test1();
		Thread t1 = new Test1();
		t1.start();
	}

}
