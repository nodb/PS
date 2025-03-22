import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        int min = 0;
        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;  // 범위 초과 방지
            
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }
            
            if (sum >= M) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
