import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11054 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N+1];			
		int[] order = new int[N+1];
		int[] reverse = new int[N+1];
		int max = 0;
		
		Arrays.fill(order, 1);
		Arrays.fill(reverse, 1);
		
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // 현재 A 수열 값의 위치를 기준으로 오른차순의 최대 길이 구하기
			for (int j = 1; j <= i; j++) { 
				if (A[i] > A[j]) {
					order[i] = Math.max(order[j] + 1, order[i]); 
					// 현재 위치의 order값을 계속 갱신해준다.
				}
			}
		} 
		
		for (int i = N; i >= 1; i--) {
			for (int j = N; j >= i; j--) {
				if (A[i] > A[j]) {
					reverse[i] = Math.max(reverse[j]+1,reverse[i]);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			max = Math.max(order[i]+reverse[i], max);
		}
	
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(order));
//		System.out.println(Arrays.toString(reverse));
		System.out.println(max-1);
	}	
}
