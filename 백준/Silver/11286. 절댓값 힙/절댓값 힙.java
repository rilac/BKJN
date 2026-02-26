import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else
                return Math.abs(o1) - Math.abs(o2);
        }
    });

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
