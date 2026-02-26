import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            list.clear();
            sb.setLength(0);
            int M = Integer.parseInt(br.readLine());
            int numCount = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                list.add(Integer.parseInt(st.nextToken()));
                numCount++;
                if (numCount % 10 == 0)
                    st = new StringTokenizer(br.readLine());
            }
            numCount = 0;
            for (int i = 1; i <= M; i++) {
                if (i % 2 != 0) {
                    List<Integer> tp = list.subList(0, i);
                    Collections.sort(tp);
                    sb.append(tp.get(i / 2));
                    numCount++;
                    if (numCount == 10)
                        sb.append("\n");
                    else
                        sb.append(" ");
                }
            }
            System.out.println(numCount);
            System.out.println(sb);
        }
    }
}
