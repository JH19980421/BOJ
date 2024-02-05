import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N+1];
		int[] answer = new int[N+1];
		int count = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		for (int i = 1; i <= N; i++) {
			answer[i] = P[i] + answer[i-1];
			count += answer[i];
		}

		System.out.println(count);
	}
}
