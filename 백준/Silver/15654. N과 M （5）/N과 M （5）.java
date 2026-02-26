import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] picked;
    static int[] nums;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        picked = new int[M];
        Arrays.sort(nums);
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
            if (selected[i]) continue;
            selected[i] = true;
            picked[depth] = nums[i];
            permute(depth + 1);
            selected[i] = false;
        }
    }
}
