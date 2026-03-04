import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] game = new int[101];
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int location = 1;
        dist[location] = 0;
        for (int i = 1; i <= 100; i++) game[i] = i;
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            game[x] = y;
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(location);

        while (!q.isEmpty()) {
            location = q.poll();
            int[] next = new int[]{1, 2, 3, 4, 5, 6};
            for (int nx : next) {
                if (location + nx > 100) continue;
                int dest = game[location + nx];
                if (dest == 100) {
                    System.out.println(dist[location] + 1);
                    return;
                }
                if (dist[dest] != -1) continue;
                dist[dest] = dist[location] + 1;
                q.offer(dest);

            }

        }
    }
}