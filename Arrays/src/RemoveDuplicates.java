import java.util.Scanner;

public class RemoveDuplicates {

	static void duplicateRemove(int[] arr) {
		int size = arr.length;
		for(int i = 0; i < size; i++) {
			for(int j = i + 1; j < size; j++) {
				if(arr[i] == arr[j]) {
					for(int k = j; k < size - 1; k++) {
						arr[k] = arr[k + 1];
					}
					size--;
					j--;
				}
			}
		}
		System.out.println("Duplicates are removed and remaining are:");
		for(int i = 0; i < size; i++) {
			System.out.println(arr[i]);
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

		duplicateRemove(arr);

	}

}
