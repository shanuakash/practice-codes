package sorts;
import java.util.Arrays;

public class Sorts {

	public static void main(String[] args) {
		int[] arr = {34,1,233,5,65,3,456,44,32,34,76,45,332,345};
	//	int[] arrA = {3,1,1,1,1,1,1,2};
	//	arr = arrA;
		int[] newArr = arr.clone();
		System.out.println(Arrays.toString(newArr));
		selectionSort(newArr);
		System.out.println(Arrays.toString(newArr));
		newArr = arr.clone();
		insertionSort(newArr);
		System.out.println(Arrays.toString(newArr));
		newArr = arr.clone();
		bubbleSort(newArr);
		System.out.println(Arrays.toString(newArr));
		newArr = arr.clone();
		QuickSort.sort(newArr);
		System.out.println(Arrays.toString(newArr));
		newArr = arr.clone();
		MergeSort.sort(newArr);
		System.out.println(Arrays.toString(newArr));
	}

	
	private static void bubbleSort(int[] arr)
	{
		int limit = arr.length;
		int temp = -1;
		boolean notSwapped = true;
		while(limit > 1)
		{
			for(int i = 1; i < limit;i++)
			{
				if(arr[i] < arr[i-1])
				{
					temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					notSwapped = false;
				}
			}
			
			if(notSwapped)
			{
				break;
			}
			notSwapped = true;
			limit--;
		}
		
	}
	private static void insertionSort(int[] arr)
	{
		int temp,prev;
		temp = prev = -1;
		for(int i = 1; i < arr.length; i++)
		{
			temp = arr[i];
			prev = i-1;
			while(prev > -1 && arr[prev] > temp)
			{
				arr[prev+1] = arr[prev];
				prev--;
			}
			arr[prev+1] = temp;
		}
	}
	
	private static void selectionSort(int[] arr)
	{
		int minIndex,temp;
		minIndex = temp = -1;
		for(int i = 0; i < arr.length; i++)
		{
			minIndex = i;
			for(int j = i+1; j < arr.length; j++)
			{
				if(arr[j] < arr[minIndex])
				{
					minIndex = j;
				}
			}
			
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
