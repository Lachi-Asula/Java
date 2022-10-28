
class Hero{
	public void display(String name) {
		System.out.println("hi " + name );
		synchronized(this) {
			System.out.println("Welcome " + name);
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
			
			}
		}
		System.out.println("Done by " + name);	
	}
	
}

class MyThread1 extends Thread{
	Hero h;
	 MyThread1(Hero h){
		 this.h = h;
	 }
	 
	 public void run() {
		 h.display("PK");
	 }
}

class MyThread2 extends Thread{
	Hero h;
	 MyThread2(Hero h){
		 this.h = h;
	 }
	 
	 public void run() {
		 h.display("MB");
	 }
}

public class HeroDemo {

	public static void main(String[] args) {
		Hero h = new Hero();
		MyThread1 m1 = new MyThread1(h);
		MyThread2 m2 = new MyThread2(h);
		
		m1.start();
		m2.start();
	}

}
