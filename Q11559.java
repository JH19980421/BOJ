import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Q11559 {
    static char[][] map;
    static boolean[][] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Puyo> queue = new LinkedList<>();
    static Queue<int[]> store = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[13][7];
        boolean chain = true;

        for (int i = 1; i <= 12; i++) {
            String s = br.readLine();
            for (int j = 1; j <= 6; j++) map[i][j] = s.charAt(j - 1);
        }

        while (chain) {
            chain = false;
            check = new boolean[13][7];

            for (int i = 1; i <= 12; i++) {
                for (int j = 1; j <= 6; j++) {
                    if (map[i][j] != '.' && !check[i][j]) {
                        if (bfs(new Puyo(i, j, map[i][j])) > 3) {
                            chain = true;
                            disconnect();
                        }
                        store.clear();
                    }
                }
            }

            if (chain) {
                answer++;
                move();
            }
        }
        System.out.println(answer);
    }

    static void move() {
        for (int j = 1; j <= 6; j++) {
            int temp = 12;
            for (int i = 12; i >= 1; i--) {
                if (map[i][j] != '.') map[temp--][j] = map[i][j];
            }
            while (temp > 0) map[temp--][j] = '.';
        }
    }

    static void disconnect() {
        while(!store.isEmpty()) {
            int[] arr = store.poll();
            map[arr[0]][arr[1]] = '.';
        }
    }

    static int bfs(Puyo puyo) {
        queue.add(puyo);
        store.add(new int[]{puyo.x, puyo.y});
        check[puyo.x][puyo.y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Puyo temp = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int sx = temp.x + dx[i];
                int sy = temp.y + dy[i];

                if ((sx <= 12 && sy <= 6 && sx >= 1 && sy >= 1) && map[sx][sy] == temp.color && !check[sx][sy]) {
                    queue.add(new Puyo(sx,sy,temp.color));
                    store.add(new int[] {sx,sy});
                    check[sx][sy] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

class Puyo {
    int x;
    int y;
    char color;
    public Puyo(int x, int y, char color) {
        this.x=x;
        this.y=y;
        this.color = color;
    }
}