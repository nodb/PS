import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = Integer.MAX_VALUE / 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M + 1];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int dp[][][] = new int[3][N][M + 2];
		for (int x = 1; x <= M; x++) {
			dp[0][0][x] = arr[0][x];
			dp[1][0][x] = arr[0][x];
			dp[2][0][x] = arr[0][x];
		}
		for (int k = 0; k < 3; k++) {
			dp[k][0][0] = MAX;
			dp[k][0][M + 1] = MAX;
		}

		for (int y = 1; y < N; y++) {
			for (int x = 0; x < M + 2; x++) {
				if (x == 0 || x == M + 1) {
					dp[0][y][x] = MAX;
					dp[1][y][x] = MAX;
					dp[2][y][x] = MAX;
					continue;
				}
				dp[0][y][x] = Math.min(dp[1][y - 1][x - 1], dp[2][y - 1][x - 1]) + arr[y][x];
				dp[1][y][x] = Math.min(dp[0][y - 1][x], dp[2][y - 1][x]) + arr[y][x];
				dp[2][y][x] = Math.min(dp[0][y - 1][x + 1], dp[1][y - 1][x + 1]) + arr[y][x];
			}
		}
//		for (int y = 0; y < N; y++) {
//			for (int k = 0; k < 3; k++) {
//				System.out.print("[");
//				for (int x = 0; x < M + 2; x++) {
//					System.out.print(dp[k][y][x] + "\t");
//				}
//				System.out.print("]");
//			}
//			System.out.println();
//		}
		int min = MAX;
		for (int k = 0; k < 3; k++) {
			for (int x = 1; x <= M; x++) {
				min = Math.min(dp[k][N-1][x], min);
			}
		}
		System.out.println(min);
	}
}
