import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] puzzle;
    static int[][] dist;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        puzzle = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            for (char c : st.nextToken().toCharArray()) {
                puzzle[i][idx++] = c - '0';
            }
        }
        bfs(0, 0);
        System.out.println(dist[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (puzzle[nr][nc] == 0) continue;
                if (dist[nr][nc] != 0) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}