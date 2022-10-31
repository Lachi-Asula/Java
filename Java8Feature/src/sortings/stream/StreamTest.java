package sortings.stream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
	private int pid;
	private String pname;
	private double price;
	
	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
//
//	@Override
//	public int compare(Product o1, Product o2) {
//		Integer x = (int)o1.getPid();
//		Integer y = (int)o2.getPid(); 
//		return x.compareTo(y);
//	}
//
//	public Product() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	

	
}
public class StreamTest {

	public static void main(String[] args) {
		List<Product> li = new ArrayList();
		
		Product p1 = new Product(1, "lachi", 10000);
		Product p2 = new Product(21, "shubhamm", 2000);
		Product p3 = new Product(11, "siva", 50000);
		Product p4 = new Product(9, "gopi", 46000);
		Product p5 = new Product(6, "sai", 9000);
		
		li.add(p1);
		li.add(p2);
		li.add(p3);
		li.add(p4);
		li.add(p5);
		
		Stream<Product> s = li.stream();
	//	List<Product> res = s.sorted(new Product()).collect(Collectors.toList());
	//	System.out.println(res);
		
		List<Product> res = s.sorted(Comparator.comparingInt(x -> x.getPid())).collect(Collectors.toList());
		res.forEach(x -> System.out.println(x));

	}

}
