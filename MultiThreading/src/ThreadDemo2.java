
public class ThreadDemo2 extends Thread{
	public void run () {
		System.out.println(Thread.currentThread().getState() + "Child");
	}
	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadDemo2 t = new ThreadDemo2();
		System.out.println(t.getState() + "main");
		t.start();
		t.sleep(1000);
		System.out.println(t.getState() + "main");
	}

}
