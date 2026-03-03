import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int[] isQ = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) isQ[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (isQ[i] == 0)
                dq.offer(Integer.parseInt(st.nextToken()));
            else
                st.nextToken();
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tp = Integer.parseInt(st.nextToken());

            if (dq.isEmpty())
                sb.append(tp).append(" ");
            else {
                sb.append(dq.pollLast()).append(" ");
                dq.offerFirst(tp);
            }
        }
        System.out.println(sb);
    }
}