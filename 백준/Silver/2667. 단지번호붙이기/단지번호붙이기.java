import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] village;
    static boolean[][] visited;
    static List<Integer> houses = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        village = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int idx = 0;
            for (char c : s.toCharArray()) {
                village[i][idx++] = c - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (village[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int tp = bfs(new int[]{i, j});
                    houses.add(tp);
                }
            }
        }
        Collections.sort(houses);
        StringBuilder sb = new StringBuilder();
        sb.append(houses.size()).append("\n");
        for (int i : houses)
            sb.append(i).append("\n");
        System.out.println(sb);
    }

    static int bfs(int[] start) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;
                if (village[nr][nc] == 0 || visited[nr][nc])
                    continue;
                cnt++;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return cnt;
    }
}