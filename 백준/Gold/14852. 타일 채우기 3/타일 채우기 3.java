import java.io.*;

public class Main {
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n + 1]; // n 최댓값 : 1,000,000
		int sum[] = new int[n + 1]; // 누적 합 저장 배열
		dp[0] = 1;
		dp[1] = 2;
		sum[0] = 1; // dp[0]
		sum[1] = 3; // dp[1] + sum[0]
		
		if (n >= 2) {
			dp[2] = 7;
			sum[2] = 10; // dp[2] + sum[1]

			for (int i = 3; i <= n; i++) {
				dp[i] = (int) ((2L * (dp[i - 1] + sum[i - 3]) + 3L * dp[i - 2]) % MOD);
				sum[i] = (sum[i - 1] + dp[i]) % MOD;
			}
		}
		
		System.out.println(dp[n]);
	}
}
