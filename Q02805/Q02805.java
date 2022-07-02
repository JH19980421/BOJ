import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q02805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] tree = new long[(int) N];
		
		st = new StringTokenizer(br.readLine());
		long max = 0; // right
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		max++;
		long min = 0; // left
		long mid;     // 탐색값
		long count;   // 현재 자른 나무 길이
		while (min<max) {
			
			count = 0;
			mid = (min+max)/2;
			for (int i = 0; i < tree.length; i++) {
				if (tree[i] > mid) { // 탐색값보다 낮은 나무는 안잘림
					count += (tree[i]-mid);  // count 구하기
				}
			}
			
			if (count < M) { // 자른 총 나무의 길이가 M 보다 작으면 max값을 조정해 더 많이 자르게 한다.
				max = mid;
			}else {          // 자른 총 나무의 길이가 M 보다 크면 min값을 조정해 덜 자른다.
				min = mid + 1;  // mid 값까지 탐색을 했으니 그 크기에 1을 더해 다음 값 탐색
			}
		}
		
		System.out.println(min-1);
	}

}
