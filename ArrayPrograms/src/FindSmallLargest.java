import java.util.Scanner;

public class FindSmallLargest {

	static void smallLargest(int[] arr) {
		for(int i = 0; i < arr.length;i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("Smallest elements is: " + arr[0]);
		System.out.println("Largest elements is: " + arr[arr.length-1]);
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
