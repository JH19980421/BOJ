import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11279 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
            	sb.append(queue.isEmpty() ? 0 : queue.poll());
            	sb.append('\n');
            } else {
            	queue.add(x);
            }
        }
       
        System.out.println(sb.toString());
	}
}
