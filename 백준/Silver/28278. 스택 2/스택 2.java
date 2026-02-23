import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                q.offerFirst(Integer.parseInt(st.nextToken()));
            } else {
                operate(cmd);
            }
        }
    }

    static void operate(int cmd) {
        if (cmd == 2) {
            if (q.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(q.poll());
            }
        } else if (cmd == 3) {
            System.out.println(q.size());
        } else if (cmd == 4) {
            if (q.isEmpty()) {
                System.out.println(1);
            } else
                System.out.println(0);
        } else if (cmd == 5) {
            if (q.isEmpty()) {
                System.out.println(-1);
            } else
                System.out.println(q.peek());
        }
    }
}
