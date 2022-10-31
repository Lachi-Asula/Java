package arrays;
import java.util.Scanner;

public class DuplicateArray {

	static void duplicateArr(int[] arr) {
		int x = 0;
		int[] dup = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			boolean b = true;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					for(int k = 0; k < x; k++) {
						if(arr[i] == arr[k]) {
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
		
		System.out.println("Duplicate Numbers are:" );
		for(int i = 0; i < x; i++) {
			System.out.print(dup[i] + " ");
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

		duplicateArr(arr);

	}

}
