import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] infected;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        int computers = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());
        graph = new ArrayList[computers + 1];
        infected = new boolean[computers + 1];

        for (int i = 1; i <= computers; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[l].add(r);
            graph[r].add(l);
        }
        infected[1] = true;
        dfs(1);

        System.out.println(result);
    }

    static void dfs(int node) {
        for (int n : graph[node]) {
            if (infected[n]) continue;
            infected[n] = true;
            result++;
            dfs(n);
        }
    }
}