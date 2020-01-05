import java.util.ArrayList;

public class Seats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private int getSeats(String input)
	{
		int result = 0;
		if(input == null || input.length() < 2)
		{
			return result;
		}
		ArrayList<Node> list = new ArrayList<Node>();
		char prev = input.charAt(0);
		return result;
	}
	
	private static class Node
	{
		int size;
		int left;
		int right;
		
		public Node(int size, int left, int right)
		{
			this.size = size;
			this.left = left;
			this.right = right;
		}
	}
}
