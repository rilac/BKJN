import java.util.*;
import java.io.*;

public class Main {
    static Deque<Character> q = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String result;

    public static void main(String[] args) throws IOException {
        while (true) {
            q.clear();
            result = "yes";
            String str = br.readLine();
            if (str.equals("."))
                return;
            for (char c : str.toCharArray()) {
                if (c == '.')
                    break;
                else if (c == '(' || c == '[')
                    q.offerFirst(c);
                else if (c == ')') {
                    if (!q.isEmpty() && q.peek() == '(')
                        q.poll();
                    else {
                        result = "no";
                        break;
                    }
                } else if (c == ']') {
                    if (!q.isEmpty() && q.peek() == '[')
                        q.poll();
                    else {
                        result = "no";
                        break;
                    }
                }
            }
            if (!q.isEmpty())
                result = "no";
            System.out.println(result);
        }
    }
}