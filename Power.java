
public class Power {

	public static void main(String[] args) {
		int a, b;
		a = 3; b = 10;
		System.out.println(a + " to the power of " + b + " = " + power(a,b) );
	}
	
	private static int power(int m, int n)
	{
		if(n <= 0)
			return 1;
		
		int result = 1;
		int cm = m;
		while(n > 0)
		{
			if(n % 2 == 1)
			{
				result *= cm;
			}
			
			cm *= cm;
			n = n/2;
		}
		
		return result;
	}
}
