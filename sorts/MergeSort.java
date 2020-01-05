package sorts;

public class MergeSort {
	public static void sort(int[] input)
	{
		int[] buff = new int[input.length];
		mergeSortImpl(input, buff, 0, input.length-1);
	}
	
	
	private static void mergeSortImpl(int[] input, int[] buff, int low, int high)
	{
		if(low < high)
		{
			int mid = low + (high-low)/2;
			
			mergeSortImpl(input, buff, low, mid);
			mergeSortImpl(input, buff, mid+1, high);
			
			merge(input, buff, low, mid, high);
		}
	}
	private static void merge(int[] input, int[] buff, int low, int mid, int high)
	{
		int left, right;
		left = low;
		right = mid+1;
		int i = low;
		while(left <= mid && right <= high)
		{
			if(input[left] <= input[right])
			{
				buff[i++] = input[left];
				left++;
			}
			else
			{
				buff[i++] = input[right];
				right++;
			}
		}
		
		while(left <= mid)
		{
			buff[i++] = input[left];
			left++;
		}
		
		while(right <= high)
		{
			buff[i++] = input[right];
			right++;
		}
		
		for(i = low; i <= high; i++)
		{
			input[i] = buff[i];
		}
	}
}
