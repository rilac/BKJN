import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static boolean[] selected;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new boolean[N + 1];
        picked = new int[M];
        combine(0);
        System.out.println(sb);
    }

    static void combine(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {

                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            picked[depth] = i;
            combine(depth + 1);
            selected[i] = false;
        }
    }
}