package lecture14.basic;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) {
		for(int n = 10; n < 10000000; n *= 10) {
			double linearAverage = 0, binaryAverage = 0;
			
			for(int j = 0; j < 100; j++) {
				int arr[] = new int[n];
				
				for(int i = 0; i < n; i++)
					arr[i] = (int)(Math.random() * 4 * n);
				
				Arrays.sort(arr);
				
				long time = System.nanoTime();
				for(int i = 0; binarySearch(arr, i) == -1; i++);
				binaryAverage += (System.nanoTime() - time) / 1000000d;
				
				time = System.nanoTime();
				for(int i = 0; linearSearch(arr, i) == -1; i++);
				linearAverage += (System.nanoTime() - time) / 1000000d;
			}
			
			System.out.println("Size: " + n);
			System.out.println("Linear Average: " + new DecimalFormat("#.####").format(linearAverage / 100d) + " ms");
			System.out.println("Binary Average: " + new DecimalFormat("#.####").format(binaryAverage / 100d) + " ms");
		}
	}
	
	private static int binarySearch(int[] arr, int searchValue) {
		int left = 0, right = arr.length - 1, index = (left + right) / 2;
		
		while(arr[index] != searchValue) {
			if(left > right)
				return -1;
			
			index = (left + right) / 2;
			
			if(arr[index] > searchValue)
				right = index - 1;
			else if(arr[index] < searchValue)
				left = index + 1;
		}
		
		return searchValue;
	}
	
	private static int linearSearch(int[] arr, int searchValue) {
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == searchValue)
				return searchValue;
		
		return -1;
	}
}
