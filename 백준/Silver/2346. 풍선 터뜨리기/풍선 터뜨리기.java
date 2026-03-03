import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            q.offer(new int[]{value, i});
        }
        while (q.size() > 1) {
            int[] target = q.poll();
            sb.append(target[1]).append(" ");

            if (target[0] > 0) {
                for (int i = 0; i < target[0] - 1; i++) {
                    q.offer(q.poll());
                }
            } else {
                for (int i = 0; i < Math.abs(target[0]); i++) {
                    q.offerFirst(q.pollLast());
                }
            }
        }
        sb.append(q.poll()[1]);
        System.out.println(sb);
    }
}
