import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> q = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                q.offerFirst(Integer.parseInt(st.nextToken()));
            } else if (cmd == 2) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else {
                command(cmd);
            }
        }
        System.out.println(sb);
    }

    static void command(int cmd) {
        if (cmd == 3)
            sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
        else if (cmd == 4)
            sb.append(q.isEmpty() ? -1 : q.pollLast()).append('\n');
        else if (cmd == 5)
            sb.append(q.size()).append('\n');
        else if (cmd == 6)
            sb.append(q.isEmpty() ? 1 : 0).append('\n');
        else if (cmd == 7)
            sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
        else if (cmd == 8)
            sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
    }
}