class SolutionC {
	
	public static void main(String[] args)
	{
		/*
		 * char[][] input =
		 * {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','
		 * 1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
		 * System.out.println(maximalSquare(input));
		 
		 */
		Integer i = new Integer("1");
		
		Integer j = i;
		j++;
		System.out.println(j);
		System.out.println(i);
	}
    public static int maximalSquare(char[][] matrix) { int length = 0;
    if(matrix == null || matrix.length == 0)
    {
        return 0;
    }
   Size[][] sizeMx = new Size[matrix.length][matrix[0].length];
   for(int i = 0; i < matrix[0].length; i++)
   {
   	if(matrix[0][i] == '1')
   	{
   		if(i > 0 && sizeMx[0][i-1] != null)
   		{
   			sizeMx[0][i] = new Size(sizeMx[0][i-1].width + 1, 1);
   		}
   		else
   		{
   			sizeMx[0][i] = new Size(1,1);
   		}
   		
   		length = compareSize(sizeMx[0][i], length);
   	}
   }
   
   for(int i = 1; i < matrix.length; i++)
   {
       if(matrix[i][0] == '1')
       {
           if(sizeMx[i-1][0] != null)
   	{
   		sizeMx[i][0] = new Size(1, sizeMx[i-1][0].height + 1);
   	}
   	else
   	{
   		sizeMx[i][0] = new Size(1,1);
   	}
   	length = compareSize(sizeMx[i][0], length);
       }
   	
   }
   for(int i = 1 ; i < matrix.length; i++)
   {
   	for(int j = 1; j < matrix[i].length; j++)
   	{
   		if(matrix[i][j] == '1')
   		{
   			if(sizeMx[i][j-1] != null && sizeMx[i-1][j] != null)
       		{
       			if(sizeMx[i][j-1].height <= 1 && sizeMx[i-1][j].width <= 1)
           		{
           			if(sizeMx[i][j-1].width > sizeMx[i-1][j].height)
           			{
           				sizeMx[i][j] = new Size(sizeMx[i][j-1].width + 1, 1);
           			}
           			else
           			{
           				sizeMx[i][j] = new Size(1, sizeMx[i-1][j].height);
           			}
           		}
       			else
       			{
       				int width = 0;
       				int height = 0;
       				width = sizeMx[i][j-1].width + 1;
       				if(sizeMx[i-1][j].height < sizeMx[i][j-1].height - 1)
       				{
       					height = sizeMx[i-1][j].height + 1;
       				}
       				else
   					{
       					height = sizeMx[i][j-1].height;
   					}
       					
       				int width1 = 0;
       				int height1 = sizeMx[i-1][j].height + 1;
       				if(sizeMx[i][j-1].width < sizeMx[i-1][j].width - 1)
       				{
       					width1 = sizeMx[i][j-1].width + 1;
       				}
       				else
       				{
       					width = sizeMx[i-1][j].width;
       				}
       				
       				if(width * height < width1 * height1)
       				{
       					width = width1;
       					height = height1;
       				}
       				sizeMx[i][j] = new Size(width, height);
       			}
       		}
       		else if(sizeMx[i][j-1] != null)
       		{
       			sizeMx[i][j] = new Size(sizeMx[i][j-1].width + 1, 1);
       		}
       		else if(sizeMx[i-1][j] != null)
       		{
       			sizeMx[i][j] = new Size(1, sizeMx[i-1][j].height + 1);
       		}
   			length = compareSize(sizeMx[i][j], length);
   		}
   	}
   }
   return length*length;
   
   }
    
    private static int compareSize(Size size, int maxSq)
    {
    	if(size == null)
    	{
    		return maxSq;
    	}
    	if(size.width < size.height)
    	{
    		if(maxSq > size.width)
    		{
    			return maxSq;
    		}
    		else
    		{
    			return size.width;
    		}
    	}
    	else
    	{
    		if(maxSq > size.height)
    		{
    			return maxSq;
    		}
    		else
    		{
    			return size.height;
    		}
    	}
    }
    private static class Size
    {
    	int width;
    	int height;
    	
    	public Size(int x, int y)
    	{
    		this.width = x;
    		this.height = y;
    	}
    }
}