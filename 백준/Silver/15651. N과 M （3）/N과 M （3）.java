import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static boolean[] selected;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new boolean[N];
        picked = new int[M];

        permute(0);
        System.out.println(sb);

    }

    static void permute(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(picked[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            picked[depth] = i + 1;
            permute(depth + 1);
        }
    }
}
