import java.util.Arrays;

public class SegmentTreeOrg {
	private int[] sumArr = null;
	private int[] baseArr = null;
	public SegmentTreeOrg(int[] baseArr)
	{
		this.baseArr = Arrays.copyOf(baseArr, baseArr.length);
		this.sumArr= new int[this.baseArr.length * 2 +2];
		buildTree(0,this.baseArr.length-1,0);
		System.out.println(Arrays.toString(this.sumArr));
	}
	
	private void buildTree(int l, int r, int currIndex)
	{
		if(l == r)
		{
			this.sumArr[currIndex] = this.baseArr[l];
		}
		else
		{
			int mid = l + (r-l)/2;
			buildTree(l, mid, 2*currIndex + 1);
			buildTree(mid + 1, r, 2*currIndex + 2);
			this.sumArr[currIndex] = this.sumArr[2*currIndex+1] + this.sumArr[2*currIndex+2]; 
		}
	}
	
	public void updateArray(int index, int value)
	{
		int diff = value - this.baseArr[index];
		this.baseArr[index] = value;
		this.sumArr[0] += diff;
		int mid = (this.baseArr.length - 1)/2;
		if(index <= mid)
		{
			updateArrImpl(1,0, mid,index, diff);
		}
		else
		{
			updateArrImpl(2, mid + 1, this.baseArr.length - 1, index, diff);
		}
	}
	
	private void updateArrImpl(int currentIndex,int l, int r, int index, int diff)
	{
		if(l == r)
		{
			this.sumArr[currentIndex] += diff; 
		}
		else
		{
			this.sumArr[currentIndex] += diff;
			int mid = l + (r-l)/2;
			if(index <= mid)
			{
				updateArrImpl(2*currentIndex + 1, l, mid, index, diff);
			}
			else
			{
				updateArrImpl(2*currentIndex + 2, mid+1, r, index, diff);
			}
		}
	}
	
	public int getRangeSum(int start, int end)
	{
		if(start > end || start < 0 || start >= this.baseArr.length || end < 0 || end >= this.baseArr.length)
		{
			return -1;
		}
		return getSumImpl(0, 0, this.baseArr.length -1, start, end);
	}
	
	private int getSumImpl(int currentIndex, int l , int r, int start, int end)
	{
		if(l == r || (start == l && end == r))
		{
			return this.sumArr[currentIndex];
		}
		else
		{
			int mid = l + (r-l)/2;
			if(end <= mid)
			{
				return getSumImpl(currentIndex * 2 + 1, l, mid, start, end);
			}
			else if(start > mid)
			{
				return getSumImpl(currentIndex * 2 + 2, mid + 1, r, start, end);
			}
			else
			{
				return getSumImpl(currentIndex * 2 + 1, l, mid, start, mid)
						+ getSumImpl(currentIndex * 2 + 2, mid + 1, r, mid + 1, end);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		int[] input = {2,5,9,7,4,3};
		SegmentTreeOrg st = new SegmentTreeOrg(input);
		System.out.println(st.getRangeSum(1, 3));
		System.out.println(st.getRangeSum(2, 5));
		st.updateArray(1, 10);
		System.out.println(st.getRangeSum(1, 3));
	}

}
