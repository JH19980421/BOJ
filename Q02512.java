import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q02512 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long N = Long.parseLong(br.readLine());
		st = new StringTokenizer(br.readLine());
		long [] city = new long[(int) N]; 
		long sum = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			city[i] = Long.parseLong(st.nextToken());
			sum += city[i];
			max = Math.max(max, city[i]);
		}
		
		long money = Integer.parseInt(br.readLine());
		
		if (sum <= money) {
			System.out.println(max);
			return;
		}
		
		max = money;
		long min = 0;
		
		
//		System.out.println(Arrays.toString(city));
		
		long mid;
		long count;
		
		while (min<=max) {
			count = 0;
			mid = (min+max)/2; // 상한값
			
			for (int i = 0; i < N; i++) {
				if (city[i] > mid) {
					count += mid;
				} else {
					count += city[i];
				}
			}
			
			if (count > money) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
			
		}
		
		System.out.println(max);
	}
}
