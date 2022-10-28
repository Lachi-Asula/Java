import java.util.Arrays;
import java.util.Scanner;

public class SecondBigSmall {
	static void smallLargest(int[] arr) {
		Arrays.sort(arr);
		System.out.println("Second Smallest elements is: " + arr[1]);
		System.out.println("Second Largest elements is: " + arr[arr.length-2]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array size");
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Enter elements into array: ");
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		smallLargest(arr);
	}
}
