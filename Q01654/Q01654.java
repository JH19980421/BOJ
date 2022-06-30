import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q01654 {

	static long[] K_Array;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long max = 0; // 가지고 있는 랜선들 중에 가장 긴 랜선
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
		int N = Integer.parseInt(st.nextToken()); // 만들어야 하는 랜선 개수
		K_Array = new long[K];               // 가지고 있는 랜선들의 길이를 저장하는 배열
		
		for (int i = 0; i < K; i++) {
			K_Array[i] = Long.parseLong(br.readLine());
			max = Math.max(max, K_Array[i]);
		}
		
		System.out.println(ParametricSearch(max, N));
	}
	
	static long ParametricSearch(long max, int N) {
		
		long min = 0; // 최솟값
		
		while (min<max) {

			long count = 0;
			long mid = (min + max)/2;
			
			for (int i = 0; i < K_Array.length; i++) {
				count += (K_Array[i]/mid);
			}
			
			if (count < N) {
				max = mid;
			}else {
				min = mid + 1;
			}
		}
	    return min-1;
	}
}
