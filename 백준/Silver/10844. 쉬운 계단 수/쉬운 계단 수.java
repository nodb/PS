import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n + 1][10];
		for (int i = 1; i <= 9; i++)
			dp[0][i] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
			}
		}
		int sum = 0;
		for (int i : dp[n - 1])
			sum = (sum + i) % 1_000_000_000;
		System.out.println(sum);
	}
}