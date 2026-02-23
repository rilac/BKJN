import java.util.*;
import java.io.*;

public class Main {
    static Deque<Character> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            q.clear();
            String str = br.readLine();
            String result = "YES";
            for (char c : str.toCharArray()) {
                if (c == '(')
                    q.offer(c);
                else if (c == ')' && !q.isEmpty()) {
                    q.poll();
                } else if (c == ')') {
                    result = "NO";
                    break;
                }
            }
            if (!q.isEmpty())
                result = "NO";
            System.out.println(result);
        }
    }
}
