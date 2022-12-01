import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q01904 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+3];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
//		dp[4] = 5;
//		dp[5] = 8;
		
		for (int i = 4; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
		
		System.out.println(Arrays.toString(dp)); //범위초과로 인해 22번째 줄로 연산 옮김
		System.out.println(dp[N]);
	}
}
