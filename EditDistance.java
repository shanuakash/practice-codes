public class EditDistance {

	public static void main(String[] args) {
		System.out.println(getEdTranscript("intention","execution"));
	}
	
	private static String getEdTranscript(String source, String target)
	{
		StringBuilder sb = new StringBuilder();
		if((source == null || source.isEmpty()) && (target == null || target.isEmpty()))
		{
			return sb.toString();
		}
		
		if(source == null || source.isEmpty())
		{
			return "Add all of: " + target;
		}
		
		if(target == null || target.isEmpty())
		{
			return "Delete all of: " + source;
		}
		
		int[][] mem = new int[source.length()+1][target.length()+1];
		for(int i = 1; i < source.length()+1; i++)
		{
			mem[i][0] = i;
		}
		
		for(int j = 1; j < target.length() + 1 ; j++)
		{
			mem[0][j] = j;
		}
		
		int min;
		for(int i = 1; i < source.length()+1; i++)
		{
			for(int j = 1; j < target.length() + 1 ; j++)
			{
				if(mem[i][j-1] < mem[i-1][j])
				{
					min = mem[i][j-1]+1;
				}
				else
				{
					min = mem[i-1][j]+1;
				}
				
				if(min <= mem[i-1][j-1])
				{
					mem[i][j] = min;
				}
				else
				{
					if(source.charAt(i-1) == target.charAt(j-1))
					{
						mem[i][j] = mem[i-1][j-1];
					}
					else
					{
						if(min - 1 == mem[i-1][j-1])
						{
							mem[i][j] = min;
						}
						else
						{
							mem[i][j] = mem[i-1][j-1] + 1;
						}
					}
				}
			}
		}
		
		int i = mem.length-1; int j = mem[0].length-1;
		System.out.println("Minimum Edit Distance :" + mem[source.length()][target.length()]);
		int x,y;String step = null;
		while(i > 0 && j > 0)
		{
			if(mem[i][j-1] < mem[i-1][j])
			{
				step = "(I) <- " + target.charAt(j-1);
				x = i;y = j-1;
			}
			else
			{
				step = source.charAt(i-1)+ " -> (D)";
				x = i-1; y = j;
			}
			
			min = ((source.charAt(i-1) == target.charAt(j-1))?0:1) + mem[i-1][j-1];
			
			if(min > mem[x][y])
			{
				i = x; j = y;
				sb.insert(0, step);
			}
			else
			{
				sb.insert(0, source.charAt(i-1) + " --> " + target.charAt(j-1));
				i = i - 1; j = j - 1;
			}
			sb.insert(0, "\n");
		}
		while(i > 0)
		{
			sb.insert(0, source.charAt(i-1) + " -> (D)");
			sb.insert(0, "\n");
			i--;
		}
		while(j > 0)
		{
			sb.insert(0, "(I) <- " + target.charAt(j-1));
			sb.insert(0, "\n");
			j--;
		}
		return sb.toString();
	}
}
