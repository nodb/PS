import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int M = Integer.parseInt(br.readLine());
            int cnt = M / 2 + 1;
            sb.append(cnt).append("\n");
            
            ArrayList<Integer> list = new ArrayList<>();
            int print = 0;
            
            // M개의 숫자를 순서대로 처리 (한 줄에 최대 10개씩 주어짐)
            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) // 10개마다 입력
                	st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                Collections.sort(list);
                // 홀수번째 숫자가 입력될 때마다 중앙값을 출력
                if (i % 2 == 0) {
                    int mid = list.get(i / 2);
                    sb.append(mid);
                    print++;
                    if (print % 10 == 0) { // 한 줄에 최대 10개 출력
                        sb.append("\n");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            if (tc != T - 1) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
