package arrays;
import java.util.Scanner;

public class FindIndex {
	static String indexOfValue(int[] arr,int find) {
		String ind = "Not Found";
		for(int i = 0; i < arr.length;i++) {
			if(find == arr[i]) {
				ind = ""+i;
				break;
			}
		}
		return ind;
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
		System.out.println("Enter Specific value");
		int find = sc.nextInt();
		
		System.out.println("Index: " + indexOfValue(arr,find));

	}
}
