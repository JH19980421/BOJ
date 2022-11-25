import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01411 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] word = new String[N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}
		
		for (int i = 0; i < N-1; i++) {
			String A = word[i];
			for (int j = i+1; j < N; j++) {
				String B = word[j];
				
				if (A.length() != B.length()) {
					continue;
				}
				
				boolean check = true;
				int[] visitedA = new int[26]; 
				int[] visitedB = new int[26];
				
				for (int k = 0; k < A.length(); k++) {
					if (visitedA[A.charAt(k)-'a'] == 0 && visitedB[B.charAt(k)-'a'] == 0) {
						visitedA[A.charAt(k)-'a'] = (B.charAt(k)-'a'+1);
						visitedB[B.charAt(k)-'a'] = (A.charAt(k)-'a'+1);
						
					} else {
						if (visitedA[A.charAt(k)-'a'] != B.charAt(k)-'a'+1) {
							check = false;
							break;
						} 
					}
				}
				
				if (check) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
