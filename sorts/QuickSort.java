package sorts;

public class QuickSort {

	public static void sort(int[] input) {
		quickSortImpl(input, 0, input.length-1);
	}

	private static void quickSortImpl(int[] input, int low, int high)
	{
		if(low < high)
		{
			int pivotIndex = partition(input, low, high);
			
			quickSortImpl(input, low, pivotIndex-1);
			quickSortImpl(input, pivotIndex+1 ,high);
		}
	}
	private static int partition(int[] input, int low, int high)
	{
		int pivot = input[high];
		int i = low;
		int left = low - 1;
		int temp = -1;
		while(i < high)
		{
			if(input[i] <= pivot)
			{
				left++;
				temp = input[i];
				input[i] = input[left];
				input[left] = temp;
			}
			i++;
		}
		
		input[high] = input[left+1];
		input[left+1] = pivot;
		
		return left+1;
	}
}
