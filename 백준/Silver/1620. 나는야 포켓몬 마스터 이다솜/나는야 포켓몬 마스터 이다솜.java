import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] arr = new String[N + 1];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            arr[i] = s;
            map.put(s, i);
        }
        
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (s.chars().allMatch(Character::isDigit)) {
                sb.append(arr[Integer.parseInt(s)] + "\n");
            } else {
                sb.append(map.get(s) + "\n");
            }
        }
        System.out.print(sb);
    }
}
