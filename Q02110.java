import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q02110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N-1]-arr[0];
		
		while(left < right) {
			int mid = (left + right)/2;
			int count = 1;
			int temp = arr[0];
			
			for (int i = 1; i < N; i++) {
				if (arr[i] - temp >= mid) {
					temp = arr[i];
					count++;
				}
			}
			
			if (count < C) {
				right = mid;
			} else {
				left = mid + 1;
			} 
		}
		
		System.out.println(left-1);
	}
}
