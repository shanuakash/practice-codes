import java.util.HashMap;

class SolutionD {
	
	public static void main(String[] args)
	{
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
     public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        Integer count = null;
        for(int i = 0; i < t.length(); i++)
        {
            count = map.get(t.charAt(i));
            if(count == null)
            {
                count = new Integer("0");
            }
            map.put(t.charAt(i), count + 1);
        }
        
        int[] arrlr = new int[s.length()];
        int[] arrrl = new int[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            if(map.get(s.charAt(i)) != null)
            {
                arrlr[i] = i;
                count = map1.get(s.charAt(i));
                if(count == null)
                {
                    count = new Integer("0");
                }
                map1.put(s.charAt(i), count + 1);
            }
            else
            {
                arrlr[i] = i > 0 ? arrlr[i-1]:-1;
            }
            
        }
        if(map.size() != map1.size())
        {
            return "";
        }
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(map.get(s.charAt(i)) != null)
            {
                arrrl[i] = i;
            }
            else
            {
                arrrl[i] = i < s.length() -1 ?arrrl[i+1]:-1;
            }
        }
        
        int left = 0; int right = s.length() - 1;
        Integer lCount = null;
        Integer rCount = null;
        
        while(left < right)
        {
            lCount = map.get(s.charAt(left));
            rCount = map.get(s.charAt(right));
            if(lCount == null)
            {
                left++;
            }
            else if(rCount == null)
            {
                right--;       
            }
            else
            {
                Integer elCount = map1.get(s.charAt(left));
                Integer erCount = map1.get(s.charAt(right));
                if(elCount < lCount || erCount < rCount)
                {
                    return "";
                }
                
                if(elCount == lCount && erCount == rCount)
                {
                    break;
                }
                else if(elCount == lCount)
                {
                    map1.put(s.charAt(right), erCount - 1);
                    right--;
                }
                else if(erCount == rCount)
                {
                    map1.put(s.charAt(left), elCount - 1);
                    left++;
                }
                else 
                {
                    if(s.charAt(left) == s.charAt(right))
                    {
                        if(elCount - lCount > 2)
                        {
                        	map1.put(s.charAt(left), elCount - 2);
                        	right--;left++;
                        }
                        else
                        {
                            int d1 = arrrl[left+1] - left;
                            int d2 = right - arrlr[right-1];
                            map1.put(s.charAt(left), elCount -1);
                            if(d1 < d2)
                            {
                                left = arrrl[left+1];
                            }
                            else
                            {
                                right = arrlr[right-1];
                            }
                            
                        }
                    }
                    else
                    {
                    	map1.put(s.charAt(left), elCount - 1);
                        map1.put(s.charAt(right), erCount - 1);
                        right--;left++;
                        
                    }
                }
            }
        }
    
                             
    if(left == right && map.get(s.charAt(left)) == null)
     {
            return ("" + s.charAt(left));
     }
    else if(left < right)
     {
         return s.substring(left, right+1);
     }
     else
     {
         return "";
     }
}
}