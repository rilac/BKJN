import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        int result = 0;
        for(int i = 0; i < testCases; i++) {
            String s = br.readLine().trim();
            char[] target = s.toCharArray();

            boolean word = true;
            ArrayList<Character> list = new ArrayList<>();

            char prev = 0;
            for(int j = 0; j < target.length; j++){
                char temp = target[j];
                if(prev != temp){
                    if(list.contains(temp)) {
                        word = false;
                        break;
                    }else{
                        list.add(temp);
                    }
                    prev = temp;
                }
            }
            if(word) result++;
        }
        System.out.println(result);
    }
}