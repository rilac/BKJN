import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
            return;
        }
        Deque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        q.offer(N);
        dist[N] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] next = new int[]{cur - 1, cur + 1, cur * 2};

            for (int nx : next) {
                if (nx < 0 || nx >= MAX || dist[nx] != -1) continue;
                dist[nx] = dist[cur] + 1;
                if (nx == K) {
                    System.out.println(dist[nx]);
                    return;
                } else
                    q.offer(nx);
            }
        }
    }
}