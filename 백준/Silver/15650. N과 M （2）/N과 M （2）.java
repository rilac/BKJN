import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        picked = new int[M];
        combine(0, 0);
        System.out.println(sb);

    }

    static void combine(int idx, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(picked[i]).append(" ");
            sb.append("\n");
            return;
        }
        if (idx == N)
            return;

        picked[depth] = idx + 1;
        combine(idx + 1, depth + 1);
        combine(idx + 1, depth);
    }
}
