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
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            graph[i].sort(Collections.reverseOrder());
        }
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int node) {
        order[node] = ++cnt;

        for (int i : graph[node]) {
            if (order[i] != 0) continue;
            dfs(i);
        }
    }
}