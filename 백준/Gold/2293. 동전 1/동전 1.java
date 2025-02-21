import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] cnt = new int[k + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        cnt[0] = 1; // 0원을 만들기 위한 동전 개수는 0개

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                cnt[j] = cnt[j] + cnt[j - arr[i]];
            }
        }
        System.out.println(cnt[k] == 10001 ? -1 : cnt[k]);
    }
}