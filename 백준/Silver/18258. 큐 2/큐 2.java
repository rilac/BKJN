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
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else {
                operate(cmd);
            }
        }
        System.out.println(sb.toString());
    }

    static void operate(String cmd) {
        if (cmd.equals("pop")) {
            if (q.isEmpty())
                sb.append(-1).append("\n");
            else
                sb.append(q.poll()).append("\n");
        } else if (cmd.equals("size"))
            sb.append(q.size()).append("\n");
        else if (cmd.equals("empty"))
            if (q.isEmpty())
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        else if (cmd.equals("front"))
            if (q.isEmpty())
                sb.append(-1).append("\n");
            else
                sb.append(q.peek()).append("\n");
        else if (cmd.equals("back"))
            if (q.isEmpty())
                sb.append(-1).append("\n");
            else
                sb.append(q.peekLast()).append("\n");
    }
}