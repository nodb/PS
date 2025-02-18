import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int arr[][], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			StringTokenizer st;
			n = Integer.parseInt(br.readLine());
			arr = new int[2][n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[1][i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[2][n + 1];
			dp[0][0] = 0;
			dp[1][0] = 0;
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}