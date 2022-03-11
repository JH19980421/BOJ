import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int value = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			boolean[] check = new boolean[26];
			for (int j = 0; j < s.length()-1; j++) {
				check[s.charAt(j)-'a'] = true;
				if (s.charAt(j)!=s.charAt(j+1)) {
					if(check[s.charAt(j+1)-'a']) {
						value++;
						break;
					}
				}
			}
		}
		System.out.println(N-value);
	}
}
