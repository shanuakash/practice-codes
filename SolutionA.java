import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionA {
	public static void main(String[] args)
	{
		int[] a = {2,2,2,3,3};
		int[][] b= {{1,3},{5,4},{2,4}};
		System.out.println(Arrays.toString(new SolutionA().getMode(a, b)));
	}
    public int[] getMode(int[] A, int[][] B) {
        
        HashMap<Integer, Node> freqMap = new HashMap<Integer , Node>();
        for(int i = 0; i < A.length ; i++)
        {
            if(freqMap.get(A[i]) == null)
            {
                freqMap.put(A[i], new Node(A[i]));
            }
            else 
            {
                freqMap.get(A[i]).count++;
            }
        }
        
        Comparator<Node> comparator = new Comparator<Node>(){
          public int compare(Node s1, Node s2) { 
                if (s1.count > s2.count)
                { 
                    return -1; }
                else if (s1.count < s2.count) 
                    {return 1; }
                    else 
                    {
                        if(s1.value < s2.value)
                        {
                            return -1;
                        }
                        else if(s1.value > s2.value)
                        {
                            return 1;
                        }
                        return 0;
                    }
            }   
        };
        
        PriorityQueue<Node> pQueue = new PriorityQueue<Node>(freqMap.size(), comparator); 
        for(Map.Entry<Integer, Node> entry : freqMap.entrySet())
        {
            pQueue.add(entry.getValue());
        }
        int[] result = new int[B.length];
        Node node = null;
        Node node1 = null;
        for(int i = 0; i < B.length; i++)
        {
            node = freqMap.get(A[B[i][0] - 1]);
            pQueue.remove(node);
            node.count--;
            
            node1 = freqMap.get(B[i][1]);
            if(node1 == null)
            {
                node1 = new Node(B[i][1]);
                freqMap.put(B[i][1], node1);
                pQueue.add(node1);
                pQueue.add(node);
            }
            else
            {
                if(node1.value == node.value)
                {
                    node.count++;
                    pQueue.add(node);
                }
                else
                {
                	pQueue.remove(node1);
                	node1.count++;
                    pQueue.add(node);
                    pQueue.add(node1);
                }
            }
            A[B[i][0] - 1] = B[i][1];
            result[i] = pQueue.peek().value;
        } 
        return result;
    }
    
    private static class Node {
        int value = 0;
        int count = 0;
        
        public Node(int value)
        {
            this.value = value;
            this.count = 1;
        }
    }
}
