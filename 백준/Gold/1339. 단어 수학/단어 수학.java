import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 단어별 가중치
        long[] alpabet = new long[26];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'A';
                // 자릿수 고려 : 10^(단어 길이 - j - 1)
                alpabet[index] += Math.pow(10, word.length() - j - 1);
            }
        }
        
        ArrayList<Long> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (alpabet[i] != 0) {
                list.add(alpabet[i]);
            }
        }
        
        Collections.sort(list);
        Collections.reverse(list);
        
        long sum = 0;
        cnt = 9;
        for (Long weight : list) {
            sum += weight * cnt;
            cnt--;
        }
        
        System.out.println(sum);
    }
}
