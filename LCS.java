
public class LCS {

	public static void main(String[] args) {
		commonChild("SHINCHAN", "NOHARAAA");
	}
	
	private static void commonChild(String s1, String s2) {
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        int[][] mx = new int[m][n];
        for(int i = 1; i < n ; i++)
        {
            mx[1][i] = mx[1][i-1] == 1? 1:(s2.charAt(i-1) == s1.charAt(0) ? 1 : 0);
        }

        for(int j = 1; j < m; j++)
        {
            mx[j][1] = mx[j-1][1] == 1 ? 1 : (s2.charAt(0) == s1.charAt(j-1) ? 1 : 0);
        }

        for(int i = 2; i < m; i++)
        {
            for(int j = 2; j < n; j++)
            {
                mx[i][j] = mx[i-1][j] > mx[i][j-1] ? mx[i-1][j] : mx[i][j-1];
                if(s2.charAt(j-1) == s1.charAt(i-1))
                {
                   mx[i][j] = mx[i][j] > (mx[i-1][j-1] + 1) ? mx[i][j] : (mx[i-1][j-1] + 1);     
                }
                else
                {
                   mx[i][j] = mx[i][j] > (mx[i-1][j-1]) ? mx[i][j] : (mx[i-1][j-1]);     
                }
            }   
        }
        
        int i = m - 1;
        int j = n - 1;
        StringBuilder builder = new StringBuilder();
        while(mx[i][j] != 0)
    	{
        	if(s1.charAt(i-1) == s2.charAt(j-1))
        	{
        		if(mx[i][j] == mx[i-1][j-1] + 1)
        		{
        			builder.insert(0, s1.charAt(i-1));
        			i--;j--;
        		}
        		else
        		{
        			if(mx[i-1][j] > mx[i][j-1])
        			{
        				i--;
        			}
        			else
        			{
        				j--;
        			}
        		}
        	}
        	else
        	{
        		if(mx[i][j] == mx[i-1][j-1])
        		{
        			i--;
        			j--;
        		}
        		else if(mx[i][j] == mx[i-1][j])
        		{
        			i--;
        		}
        		else
        		{
        			j--;
        		}
        	}
    	}
        System.out.println(mx[m-1][n-1]);
        System.out.println(builder.toString());
    }
}
