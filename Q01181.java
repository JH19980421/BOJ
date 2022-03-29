import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q01181 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = new String[N];
		
		for (int i = 0; i < N; i++) {
			s[i] = br.readLine();
		}
		
		Arrays.sort(s);
		sort(s, N);
		
		for (int i = 0; i < s.length-1; i++) {
			if (s[i].equals(s[i+1])==false) {
				System.out.println(s[i]);
			}
		}
		System.out.println(s[N-1]);
	}
	
	static void swap(String[] s, int idx1, int idx2) {
		String t = s[idx1];
		s[idx1] = s[idx2];
		s[idx2] = t;
	}
	
	static void sort(String[] s, int n) {//버블 정렬
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (s[j-1].length() > s[j].length()) {
					swap(s, j-1, j);
				}
			}
		}
	}
	
	
}
