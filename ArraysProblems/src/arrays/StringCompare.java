package arrays;
import java.util.Scanner;

public class StringCompare {
	
	static void stringCompare(String[] arr1, String[] arr2) {
		String res = "";
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if(arr1[i].equals(arr2[j])) {
					res += arr1[i] + "\n";
				}
			}
		}
		System.out.println("Common Strings are: \n" + res );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Array size");
		int size1 = sc.nextInt();
		String[] arr1 = new String[size1];
		
		System.out.println("Enter Strings into First array: ");
		for(int i = 0; i < size1; i++) {
			arr1[i] = sc.next();
		}
		
		System.out.println("Enter Second Array size");
		int size2 = sc.nextInt();
		String[] arr2 = new String[size2];
		
		System.out.println("Enter Strings into Second array: ");
		for(int i = 0; i < size2; i++) {
			arr2[i] = sc.next();
		}
		
		stringCompare(arr1,arr2);
	}

}
