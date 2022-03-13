import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int value = N;
		int sum = 0;
		int count = 0;
		
		do {
			sum = value/10 + value%10;
			value = value%10*10 + sum%10;
			count++;
		} while (N!=value);
		System.out.println(count);
	}
}
