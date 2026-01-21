import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    //'A' = 65 , 'Z' = 90
    if (n == 0) {
      System.out.println(n);
      return;
    }
    StringBuilder sb = new StringBuilder();
    int digit = 0;
    while (n > 0) {
      int r = (int) (n % b);
        if (r < 10) {
            sb.append(r);
        } else {
            sb.append((char)('A'  + r - 10));
        }
      n /= b;
    }
    System.out.println(sb.reverse().toString());
  }
}