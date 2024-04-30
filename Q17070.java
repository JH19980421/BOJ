import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {

    static int N;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);

        System.out.println(count);
    }

    static void dfs(int x, int y, int direction) {
        if (x == N && y == N) {
            count++;
            return;
        }

        switch (direction) {
            case 0:
                checkOfWidth(x, y);
                break;
            case 1:
                checkOfLength(x, y);
                break;
            case 2:
                checkOfWidth(x, y);
                checkOfLength(x, y);
        }

        checkOfDiagonal(x, y);
    }

    static void checkOfDiagonal(int x, int y) {
        int sx = x + 1;
        int sy = y + 1;

        if (sx > N || sy > N) return;
        if (map[x][sy] == 0 && map[sx][y] == 0 && map[sx][sy] == 0) dfs(sx, sy, 2);
    }

    static void checkOfWidth(int x, int y) {
        int sy = y + 1;
        if (x > N || sy > N) return;
        if (map[x][sy] == 1) return;
        dfs(x, sy, 0);
    }

    static void checkOfLength(int x, int y) {
        int sx = x + 1;
        if (sx > N || y > N) return;
        if (map[sx][y] == 1) return;
        dfs(sx, y, 1);
    }
}
