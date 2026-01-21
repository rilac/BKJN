import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(Points(n));
  }
  public static int Points(int n){
    if(n == 0) return 4;
    int length = (int)Math.pow(2,n);
    return (length+1) * (length+1);
  }
}