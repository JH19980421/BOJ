import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q02606 {

    static boolean[][] map;
    static int N;
    static boolean[] answer;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];
        answer = new boolean[N+1];
        check = new boolean[N+1];
        int count = 0;
        int S = Integer.parseInt(br.readLine());

        answer[1] = true;
        map[1][1] = true;

        for (int i = 1; i <= S; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            if (answer[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int j) {
        if (check[j]) return;

        for (int i = 1; i <= N; i++) {
            if (map[j][i] && !answer[i]) {
                answer[i] = true;
                dfs(i);
                check[i] = true;
            }
        }
    }
}
