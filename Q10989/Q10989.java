import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10989 {

	static int MAX_VALUE = 7; // N의 범위
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] PutArray = new int[N];
		int[] CountingArray = new int[MAX_VALUE+1]; // 입력 값의 개수를 세기 위한 배열
		int[] ResultArray = new int[N]; // 입력 값의 개수만큼 저장할 배열
	
		
		for (int i = 0; i < N; i++) { // 입력 수열 생성
			PutArray[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) { // 입력 값의 개수 세기
			CountingArray[PutArray[i]]++;
		}
		
		for (int i = 1; i < CountingArray.length; i++) { // 입력값 누적합 구하기
			CountingArray[i] += CountingArray[i-1];
		}
		
		for (int i = N-1; i >= 0; i--) { // 역순으로 누적합을 이용하여 정렬된 배열 생성
			ResultArray[--CountingArray[PutArray[i]]] = PutArray[i];
		}
		
		for (int i = 0; i < N; i++) { 
			bw.write(ResultArray[i]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
