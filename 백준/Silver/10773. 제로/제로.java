import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int tp = Integer.parseInt(br.readLine());
            if (tp == 0) {
                q.poll();
            } else {
                q.offerFirst(tp);
            }
        }
        long result = 0L;
        while (!q.isEmpty()) {
            result += q.poll();
        }
        System.out.println(result);
    }
}
