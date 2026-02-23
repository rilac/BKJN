import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> mainLine = new ArrayDeque<>();
    static Deque<Integer> subLine = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String result;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mainLine.offer(Integer.parseInt(st.nextToken()));
        }
        String result = "Nice";
        int tp = 1;
        while (tp <= N) {
            if (!subLine.isEmpty() && subLine.peek() == tp) {
                subLine.poll();
                tp++;
            } else if (!mainLine.isEmpty() && mainLine.peek() == tp) {
                mainLine.poll();
                tp++;
            } else if (!mainLine.isEmpty() && mainLine.peek() > tp) {
                int temp = mainLine.poll();
                if (!subLine.isEmpty() && temp > subLine.peek()) {
                    result = "Sad";
                    break;
                } else {
                    subLine.offerFirst(temp);
                }
            }
        }
        System.out.println(result);
    }
}
