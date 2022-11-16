import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q13417 {
	
	static List<Character> list = new ArrayList<Character>(); 
	static Deque<Character> deque = new LinkedList<Character>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				char c = st.nextToken().charAt(0);
				list.add(c);
			}
			
			for (int k = 0; k < N; k++) {
				char temp = list.get(k);
				if (deque.isEmpty()) {
					deque.add(temp);
					continue;
				}
				
				if (deque.peek() < temp) {
					deque.addLast(temp);
				}
				
				else {
					deque.addFirst(temp);
				}
			}
			
			for (int j = 0; j < N; j++) {
				sb.append(deque.pollFirst());
			}
			
			System.out.println(sb.toString());
			list.clear();	//
			sb.setLength(0);//
		}
	}

}
