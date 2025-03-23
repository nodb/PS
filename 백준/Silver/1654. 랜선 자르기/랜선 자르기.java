import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        long min = 1;
        long result = 0;
        
        while (min <= max) {
            long mid = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }
            
            if (cnt >= N) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
