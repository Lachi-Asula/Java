package arrays;
import java.util.*;
public class AverageArray {
	
	static void average(int[] arr) {
		double avg = 0;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		avg = sum / arr.length;
		
		System.out.println("Average: " + avg);
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
		
		average(arr);

	}

}
