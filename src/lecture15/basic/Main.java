package lecture15.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("Array length: ");
		Scanner s = new Scanner(System.in);
		int[] arr = new int[s.nextInt()];
		s.close();
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = (int)(Math.random() * 4 * arr.length);
		
		int[] selectionArr = arr.clone(),
				bubbleArr = arr.clone(),
				insertionArr = arr.clone(),
				mergeArr = arr.clone();
	
		Sort.selectionSort(selectionArr);
		Sort.bubbleSort(bubbleArr);
		Sort.insertionSort(insertionArr);
		Sort.mergeSort(mergeArr);
		
		System.out.println("Original:  " + Arrays.toString(arr));
		System.out.println("Selection: " + Arrays.toString(selectionArr));
		System.out.println("Bubble:    " + Arrays.toString(bubbleArr));
		System.out.println("Insertion: " + Arrays.toString(insertionArr));
		System.out.println("Merge:     " + Arrays.toString(mergeArr));
	}
}
