package sortings.java8;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		String[] str = new String[10];
		str[5] = "lachi";
	//	String st = str[5];
		
		Optional<String> opt = Optional.ofNullable(str[3]);
		if(opt.isPresent()) {
			System.out.println(opt.get().length());
		}
		else {
			System.out.println("Empty");
		}
	}
}
