import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q04344 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] value = new int[N];
			double sum = 0,rt = 0;
			int count = 0;
			for (int j = 0; j < N; j++) {
				value[j] = Integer.parseInt(st.nextToken());
				sum += value[j];
			}
			double avg = sum / N;
			
			for (int j = 0; j < N; j++) {
				if(value[j] > avg)
					count++;
			}
			rt = ((double)count/N)*100;
			System.out.println(String.format("%.3f",rt)+"%");
		}
	}

}
