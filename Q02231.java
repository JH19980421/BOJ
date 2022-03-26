import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q02231 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int M = i;
			int count = i;
			
			while (count > 0) {
				M += count%10;
				count = count/10;
			}
			
			if(M==N) {
				System.out.println(i);
				break;
			}
			
			if(i==N) {
				System.out.println(0);
			}
		}
	}
}
