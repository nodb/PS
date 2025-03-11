import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // dp[i] : i를 만들기 위한 최소 제곱수의 개수
        int[] dp = new int[n + 1];
        // 초기값: 최악의 경우, 1의 제곱을 i번 더하는 경우이므로 dp[i] = i
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            // 제곱수 j^2가 i보다 작거나 같은 동안 반복
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
