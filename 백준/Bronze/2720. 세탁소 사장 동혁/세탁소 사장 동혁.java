import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int[] coins = {25, 10, 5, 1};

    for (int i = 0; i < t; i++) {
      int change = Integer.parseInt(br.readLine());
      for (int coin : coins) {
        System.out.printf("%d ", change / coin);
        change %= coin;
      }
      System.out.println();
    }
  }
}