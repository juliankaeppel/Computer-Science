package lecture15.basic;

public abstract class Sort {

	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int smallIndex = i;
			
			for(int j = i + 1; j < arr.length; j++)
				if(arr[j] < arr[smallIndex])
					smallIndex = j;
			
			int swap = arr[i];
			arr[i] = arr[smallIndex];
			arr[smallIndex] = swap;
		}
	}
	
	public static void bubbleSort(int[] arr) {
		boolean hasSwapped = true;
		for(int i = 0; hasSwapped && arr.length - i - 1 > 1; i++) {
			hasSwapped = false;
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int swap = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = swap;
					hasSwapped = true;
				}
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i - 1]) {
				
				int temp = arr[i];
				
				int j;
				
				for(j = i; j > 0 && arr[j - 1] > temp; j--) {
					arr[j] = arr[j - 1];
				}
				
				arr[j] = temp;
			}
		}
	}
	
	/*public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i - 1]) {
				int insert = arr[i];
				
				arr[i] = arr[i - 1];
				
				boolean hasInserted = false;
				
				for(int j = i - 2; j > 0; j--) {
					if(arr[j] < insert) {
						arr[j + 1] = insert;
						hasInserted = true;
						break;
					}
					
					arr[j + 1] = arr[j];
				}
				
				if(!hasInserted) {
					arr[1] = arr[0];
					arr[0] = insert;
				}
			}
		}
	}*/
	
	public static void mergeSort(int[] arr) {
		int[] newArr = split(arr);
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = newArr[i];
	}
	
	private static int[] merge(int[] arr1, int[] arr2) {
		int pointer1 = 0, pointer2 = 0;
		int[] arr = new int[arr1.length + arr2.length];
		int i = 0;
		
		while(pointer1 < arr1.length && pointer2 < arr2.length) {
			if(arr1[pointer1] < arr2[pointer2])
				arr[i++] = arr1[pointer1++];
			else
				arr[i++] = arr2[pointer2++];
		}
		
		for(; pointer1 < arr1.length;) {
			arr[i++] = arr1[pointer1++];
		}
		
		for(; pointer2 < arr2.length;) {
			arr[i++] = arr2[pointer2++];
		}
		
		return arr;
	}
	
	private static int[] split(int[] arr) {
		if(arr.length > 2) {
			int[] arr1 = new int[arr.length / 2];
			int[] arr2 = new int[arr.length - arr1.length];
			
			for(int i = 0; i < arr1.length; i++)
				arr1[i] = arr[i];
			for(int i = 0; i < arr2.length; i++)
				arr2[i] = arr[i + arr1.length];
			
			return merge(split(arr1), split(arr2));
		}
		
		if(arr[0] > arr[arr.length - 1]) {
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		
		return arr;
	}
}
