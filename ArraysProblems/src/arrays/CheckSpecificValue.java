package arrays;
import java.util.Scanner;

public class CheckSpecificValue {
	
	static boolean isContains(int[] arr,int find) {
		boolean b = false;
		for(int i = 0; i < arr.length;i++) {
			if(find == arr[i]) {
				b = true;
				break;
			}
		}
		return b;
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
		
		System.out.println(isContains(arr,find));

	}

}
