import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int aldy = -100;
        int[][] tomato = new int[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], aldy);
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (isRipe(tomato)) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || tomato[nr][nc] != 0 || dist[nr][nc] != aldy)
                    continue;
                tomato[nr][nc] = 1;
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        int result = Integer.MIN_VALUE;
        if (!isRipe(tomato)) {
            System.out.println(-1);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    result = Math.max(result, dist[i][j]);
                }
            }
        }
        System.out.println(result);
    }

    static boolean isRipe(int[][] tomato) {
        for (int i = 0; i < tomato.length; i++) {
            for (int j = 0; j < tomato[0].length; j++) {
                if (tomato[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}