import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		int[] count = new int[26];

		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)-'A']++;
		}
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for (int i = 0; i < count.length; i++) {
			max = Math.max(max, count[i]);
		}
		
		int value = 0;
		
		for (int i = 0; i < count.length; i++) {
			if(count[i]==max)
				value++;
		}
		
		if(value==1) {
			for (int i = 0; i < count.length; i++) {
				if(count[i]==max)
					System.out.println((char)(i+'A'));
			}
		}
		else {
			System.out.println("?");
		}
	}
}
