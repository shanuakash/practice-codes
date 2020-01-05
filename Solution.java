class Solution {
	
	public static void main(String[] args)
	{
		String p = "aa";
		String s = "a*";
		System.out.println(new Solution().isMatch(p, s));
	}
    public boolean isMatch(String s, String p) {
        if(s == null || s.isEmpty())
        {
            if(p == null || p.isEmpty())
            {
                return true;
            }
            else
            {
                if(p.length() % 2 == 0)
                {
                    for(int i = 1; i < p.length() ; i+= 2)
                    {
                        if(p.charAt(i) != '*')
                        {
                            return false;
                        }
                    }
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }     
            int[][] comp = new int[p.length()][s.length()];
            if(isMatchedImpl(0,0,p,s,comp) == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
      }
	private int isMatchedImpl(int i, int j, String p, String s, int[][] comp) {

		if(i < p.length() && j < s.length() && comp[i][j] != 0)
		{
			return comp[i][j];
		}
        if(j == s.length() && i == p.length())
        {
            return 1;
        }
        else if(j == s.length())
        {
            if(i+1 < p.length() && p.charAt(i+1) == '*')
            {
                return isMatchedImpl(i+2, j, p, s, comp);
            }
            else
            {
                return -1;
            }
        }
        else if(i == p.length())
        {
            return -1;
        }
        else
        {
            if(i+1 < p.length() && p.charAt(i+1) == '*')
            {
                if(p.charAt(i) == '.' || p.charAt(i) == s.charAt(j))
                {
                	int jj, jjj,ii;
                    jj = isMatchedImpl(i+2, j+1, p, s, comp);
                    ii = isMatchedImpl(i+2, j, p, s, comp);
                    jjj = isMatchedImpl(i, j+1, p, s, comp);
                    
                    if(i+2 < p.length())
                    {
                    	comp[i+2][j] = ii;
                    }

                    if(i+2 < p.length() && j+1 < s.length())
                    {
                    	comp[i+2][j+1] = jj;
                    }
                    
                    if(j+1 < s.length())
                    {
                    	comp[i][j+1] = jjj;
                    }
                    
                    comp[i][j] = (jj == 1 || ii == 1 || jjj == 1)? 1:-1;
                }
                else
                {
                    comp[i][j] = isMatchedImpl(i+2, j, p, s, comp);
                }
            }
            else
            {
                if(p.charAt(i) == '.' || p.charAt(i) == s.charAt(j))
                {
                    comp[i][j] = isMatchedImpl(i+1, j+1, p, s, comp);
                }
            }
            return comp[i][j];
        }
    
	}
}