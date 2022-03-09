import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q02908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int count = 0;
		
		char[] newA = new char[3];
		char[] newB = new char[3];
		
		for (int i = 2; i >= 0; i--) {
			newA[count] = A.charAt(i);
			newB[count] = B.charAt(i);
			count++;
		}
		
		int Ai = (newA[0]-'0') * 100 + (newA[1]-'0') * 10 + (newA[2]-'0');
		int Bi = (newB[0]-'0') * 100 + (newB[1]-'0') * 10 + (newB[2]-'0');
		
		System.out.println((Ai > Bi) ? Ai : Bi);
	}

}
