import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE / 2;
		for (int first = 0; first < 3; first++) {
			int dp[][] = new int[N + 1][3];
			for (int i = 0; i < 3; i++) {
				if (i == first)
					dp[1][i] = arr[1][i];
				else
					dp[1][i] = Integer.MAX_VALUE / 2;
			}
			for (int i = 2; i <= N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
			}
			for (int last = 0; last < 3; last++) {
				if (last != first) {
					min = Math.min(min, dp[N][last]);
				}
			}
		}
		System.out.println(min);
	}
}
