import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        // (해당 종류의 의상 개수 + 1)을 곱한 후, 아무것도 입지 않는 경우(알몸)를 제외하는 방식
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                hm.put(type, hm.getOrDefault(type, 0) + 1);
            }
            
            int result = 1;
            for (int count : hm.values()) {
                // count + 1은 해당 종류에서 한 개의 의상 선택 또는 선택하지 않는 경우의 수
                result *= (count + 1);
            }
            
            // 알몸인 경우(아무것도 선택하지 않은 경우)를 빼줌
            sb.append(result - 1).append("\n");
        }
        
        System.out.println(sb);
    }
}
