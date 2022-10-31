package arrays;
import java.util.Scanner;

public class DuplicateChars {
	
	static void duplicateChars(String[] arr) {
		int x = 0;
		String[] dup = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {
			boolean b = true;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i].equals(arr[j])) {
					for(int k = 0; k < x; k++) {
						if(arr[i].equals(arr[k])) {
							b = false;
							break;
						}
					}
					if(b) {
						dup[x] = arr[i];
						x++;
					}
				}
			}
		}
		
		System.out.println("Duplicate Strings are:" );
		for(int i = 0; i < x; i++) {
			System.out.print(dup[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array size");
		int size = sc.nextInt();
		String[] arr = new String[size];
		
		System.out.println("Enter Strings into array: ");
		for(int i = 0; i < size; i++) {
			arr[i] = sc.next();
		}

		duplicateChars(arr);

	}
}
