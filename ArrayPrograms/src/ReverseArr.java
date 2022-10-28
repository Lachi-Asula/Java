import java.util.Scanner;

public class ReverseArr {

	static void reverseArr(int[] arr) {
		System.out.println("Array elements in reverse order is: ");
		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]+" ");
		}
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

		reverseArr(arr);
	}

}
