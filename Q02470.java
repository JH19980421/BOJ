import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q02470 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long n = Long.parseLong(br.readLine());
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[(int)n];
		long min = Long.MAX_VALUE;
		long x = 0;
		long y = 0;
		
		
		for (long i = 0; i < n; i++) {
			arr[(int)i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = (int)n-1;
		
		while (left < right) {
			long mid = arr[left] + arr[right];
			
			if (0 == Math.abs(mid)) {
				System.out.println(arr[left]+" "+arr[right]);
				return;
			}
			
			if (min > Math.abs(mid)) {
				min = Math.abs(mid);
				x = arr[left];
				y = arr[right];
			} 
			
			if (mid > 0) {
				right--;
			} else {
				left++;
			}
		}
		
		System.out.println(x+" "+y);
		
	}
}
