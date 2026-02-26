import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> q = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sb.append("<");
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        int tp = 1;
        while (!q.isEmpty()) {
            if (tp == K) {
                sb.append(q.poll()).append(", ");
                tp = 1;
                continue;
            } else {
                q.offer(q.poll());
            }
            tp++;
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }
}