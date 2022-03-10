import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01065 {

	public static int cc;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for (int i = 1; i <= N; i++) {
			count(i);
		}
		System.out.println(cc);
	}
	
	public static int count(int a) {
		
		if(a < 100)
			return cc++;
		
		int value = a;
		int length = (int)Math.log10(a)+1;
		int[] A = new int[length];
		
		for (int i = length-1; i >= 0 ; i--) {
			A[i] = value%10;
			value = value/10;
		}
		
		int check = A[1] - A[0];
		
		for (int i = 0; i < length-1; i++) {
			if((A[i+1]-A[i])!=check)
				return 0;
		}
		return cc++;
	}
}
