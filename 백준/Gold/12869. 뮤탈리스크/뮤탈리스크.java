import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int arr[];
	static int dp[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[3];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		dp = new int[70][70][70];

		for (int i = 0; i < 70; i++) {
			for (int j = 0; j < 70; j++) {
				Arrays.fill(dp[i][j], 100);
			}
		}
		dp[1][3][9] = 1;
		dp[1][9][3] = 1;
		dp[3][1][9] = 1;
		dp[3][9][1] = 1;
		dp[9][1][3] = 1;
		dp[9][3][1] = 1;
		for (int d = 0; d < 60; d++) {
			for (int i = 0; i < 60; i++) {
				for (int j = 0; j < 60; j++) {
					for (int k = 0; k < 60; k++) {
						if (dp[i][j][k] == 100)
							continue;
						dp[i + 1][j + 3][k + 9] = Math.min(dp[i][j][k] + 1, dp[i + 1][j + 3][k + 9]);
						dp[i + 1][j + 9][k + 3] = Math.min(dp[i][j][k] + 1, dp[i + 1][j + 9][k + 3]);
						dp[i + 3][j + 1][k + 9] = Math.min(dp[i][j][k] + 1, dp[i + 3][j + 1][k + 9]);
						dp[i + 3][j + 9][k + 1] = Math.min(dp[i][j][k] + 1, dp[i + 3][j + 9][k + 1]);
						dp[i + 9][j + 1][k + 3] = Math.min(dp[i][j][k] + 1, dp[i + 9][j + 1][k + 3]);
						dp[i + 9][j + 3][k + 1] = Math.min(dp[i][j][k] + 1, dp[i + 9][j + 3][k + 1]);
					}
				}
			}
		}
		
		int min = 100;
		for (int i = arr[0]; i < 70; i++) {
			for (int j = arr[1]; j < 70; j++) {
				for (int k = arr[2]; k < 70; k++) {
					min = Math.min(min, dp[i][j][k]);
				}
			}
		}
		System.out.println(min);
	}
}