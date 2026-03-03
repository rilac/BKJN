import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static TreeSet<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static int[] order;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new TreeSet[N + 1];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new TreeSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[l].add(r);
            graph[r].add(l);
        }

        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        order[node] = ++cnt;
        for (int n : graph[node]) {
            if (order[n] != 0) continue;
            dfs(n);
        }
    }
}