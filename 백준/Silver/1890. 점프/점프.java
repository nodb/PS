import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long dp[][] = new long[n][n];
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] != 0 && arr[i][j] != 0) {
					int num = arr[i][j];
					if (i + num < n)
						dp[i + num][j] += dp[i][j];
					if (j + num < n)
						dp[i][j + num] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n - 1][n - 1]);
	}
}