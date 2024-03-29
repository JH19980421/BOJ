import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q09251 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int[][] lcs = new int[A.length()+1][B.length()+1];
		
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i-1)==B.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		System.out.println(lcs[A.length()][B.length()]);
	}
}
