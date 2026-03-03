import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] farm;
    static boolean[][] visited;
    static List<Integer> size = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            farm = new int[M][N];
            visited = new boolean[M][N];
            size.clear();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                farm[r][c] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        int tp = bfs(new int[]{i, j});
                        visited[i][j] = true;
                        size.add(tp);
                    }
                }
            }
            System.out.println(size.size());
        }
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
                if (nr < 0 || nc < 0 || nr >= M || nc >= N || visited[nr][nc]) continue;
                if (farm[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}