import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dr = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dc = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int l = Integer.parseInt(br.readLine());
            int[][] dist = new int[l][l];
            for (int i = 0; i < l; i++) Arrays.fill(dist[i], -1);

            st = new StringTokenizer(br.readLine());
            int currentR = Integer.parseInt(st.nextToken());
            int currentC = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetR = Integer.parseInt(st.nextToken());
            int targetC = Integer.parseInt(st.nextToken());
            if (currentR == targetR && currentC == targetC) {
                System.out.println(0);
                continue;
            }
            dist[currentR][currentC] = 0;
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{currentR, currentC});

            boolean done = false;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int tpR = cur[0];
                int tpC = cur[1];

                for (int i = 0; i < dr.length; i++) {
                    int nr = tpR + dr[i];
                    int nc = tpC + dc[i];

                    if (nr < 0 || nr >= l || nc < 0 || nc >= l || dist[nr][nc] != -1) continue;
                    dist[nr][nc] = dist[tpR][tpC] + 1;
                    if (nr == targetR && nc == targetC) {
                        System.out.println(dist[nr][nc]);
                        done = true;
                        break;
                    }
                    q.offer(new int[]{nr, nc});
                }
                if (done) break;
            }
        }
    }
}