
public class NonnegativeIntegerswithoutConsecutiveOnes {
	public int findIntegers(int num) {
	    if(num == 0) return 1;
	    if(num == 1) return 2;
	    int count = countBits(num);
	    int[] ones = new int[count];
	    int zeroSum = 1;
	    int sum = 0;
	    ones[0] = 1;
	    if(count > 1)
	    {
	    	ones[1] = 1;
	    }

	    for(int i = 2; i < ones.length; i++)
	    {
	        ones[i] = zeroSum;
	        zeroSum += ones[i-1];
	    }
	    
	    int[] buf = new int[count+1];
	    int in = buf.length - 2;
	    int dNum = num;
	    while(dNum > 0)
	    {
	    	buf[in] = dNum & 1;
	    	dNum = dNum >> 1;
	    	in--;
	    }
	    int last = 0;
	    for(int i = 0; i < buf.length -1 ;i++)
	    {
	    	if(buf[i] == 1 && last == 1)
	    	{
	    		for(int j = i; j < buf.length - 1; j++)
	    		{
	    			if(last == 1)
	    			{
	    				buf[j] = last = 0;
	    			}
	    			else
	    			{
	    				buf[j] = last = 1;
	    			}
	    		}
	    		break;
	    	}
	    	else
	    	{
	    		last = buf[i];
	    	}
	    }
	    
	    int multiplier = 1;
	    int c = ones.length - 1;
	    for(int i = 1; i < buf.length; i++)
	    {
	    	sum += (multiplier * ones[c]);
	    	if(buf[i] == 1)
	    	{
	    		multiplier++;
	    	}
	    	c--;
	    }
	    
	    return sum+1;
	}

	public static void main(String[] args)
	{
		System.out.println(new NonnegativeIntegerswithoutConsecutiveOnes().findIntegers(34));
	}
	private int countBits(int number) 
	{  
	     return (int)(Math.log(number) /  
	             Math.log(2) + 1); 
	}

}
