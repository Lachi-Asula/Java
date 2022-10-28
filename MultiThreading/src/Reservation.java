
public class Reservation implements Runnable{

	int available = 1;
	int wanted;
	
	Reservation(int n){
		wanted = n;
	}
	public void run() {
		desp();
	}
	
	synchronized void desp() {
		System.out.println("Available Beths are: " + available);
		String name = Thread.currentThread().getName();
		
		if(available >= wanted) {	
			System.out.println("Berth allocated for " + name);
			try {
				Thread.sleep(1000);
				available -= wanted;
			}
			catch(Exception e) {
				
			}
		}
		else {
			System.out.println("Berth is not allocated for " + name);
		}
	}
	
	public static void main(String[] args) {
		Reservation r = new Reservation(1);

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}

}
