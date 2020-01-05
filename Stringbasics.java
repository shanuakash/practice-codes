import java.util.Arrays;

public class Stringbasics {

	public static void main(String[] args) {
		String st = "abcd efg sd lasek";
		char[] arr = st.toCharArray();
		for(char c: arr)
		{
			System.out.print(c);
		}
		System.out.println();
		char[] arrCopy = Arrays.copyOf(arr, arr.length);
		for(int i = 0; i < arrCopy.length; i++)
		{
			if(arrCopy[i] == 'e')
			{
				arrCopy[i] = 'E';
			}
		}
		
		System.out.println(st);
	}
}
	