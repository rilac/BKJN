import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static int[] order;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[l].add(r);
            graph[r].add(l);
        }
        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        bfs(R);
        for (int i = 1; i <= N; i++) sb.append(order[i]).append("\n");
        System.out.print(sb);
    }

    static void bfs(int node) {
        Deque<Integer> q = new ArrayDeque<>();
        order[node] = ++cnt;
        q.offer(node);
        while (!q.isEmpty()) {
            for (int i : graph[q.poll()]) {
                if (order[i] != 0) continue;
                q.offer(i);
                order[i] = ++cnt;
            }
        }
    }
}