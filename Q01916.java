import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q01916 {
    static int N;
    static int M;
    static List<List<Edge>> map;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList<>(N+1);

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(start).add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int answer = dijkstra(map,start, end);
        System.out.println(answer);
    }

    static int dijkstra(List<List<Edge>> map, int start, int end) {
        int[] busFare = new int[map.size()];
        Arrays.fill(busFare, Integer.MAX_VALUE);
        busFare[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge temp = pq.poll();
            if (temp.cost > busFare[temp.arrive]) continue;
            for (Edge next: map.get(temp.arrive)) {
                int fare = temp.cost + next.cost;
                if (fare < busFare[next.arrive]) {
                    busFare[next.arrive] = fare;
                    pq.add(new Edge(next.arrive, fare));
                }
            }
        }

        return busFare[end];
    }
}
class Edge {
    int arrive;
    int cost;
    public Edge(int arrive, int cost) {
        this.arrive = arrive;
        this.cost = cost;
    }
}
