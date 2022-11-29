import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물품 수 
		int K = Integer.parseInt(st.nextToken()); // 가방 수용 가능 무게
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		int[][] count = new int[N+1][K+1]; 
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // 현재 물건의 무게
			for (int j = 1; j <= K; j++) { // 현재 가방의 무게
				if (W[i] > j) {
					count[i][j] = count[i-1][j];
				} else {
					count[i][j] = Math.max(count[i-1][j-W[i]] + V[i], count[i-1][j]);
				}
			}
		}
		
//		for (int i = 0; i <= N; i++) {
//			System.out.println();
//			for (int j = 0; j <= K; j++) {
//				System.out.print(count[i][j]+"  ");
//			}
//		}
		
		System.out.println(count[N][K]);
	}
}
