import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine().trim());
            operate(cmd);
        }
    }

    static void operate(int cmd) {
        if (cmd == 0 && pq.isEmpty()) {
            System.out.println(0);
        } else if (cmd == 0)
            System.out.println(pq.poll());
        else {
            pq.offer(cmd);
        }
    }
}
