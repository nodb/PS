import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long dp[][] = new long[N + 1][M + 1];
		dp[0][0] = 1;

		boolean roadX[][] = new boolean[N + 1][M + 1];
		boolean roadY[][] = new boolean[N + 1][M + 1];

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (a == c) // x가 같으면
				roadY[Math.min(b, d)][a] = true;
			else // y가 같으면
				roadX[b][Math.min(a, c)] = true;
		}

		for (int y = 0; y <= N; y++) {
			for (int x = 0; x <= M; x++) {
				if (x == 0 && y == 0)
					continue;
				dp[y][x] = (x > 0 && !roadX[y][x - 1] ? dp[y][x - 1] : 0)
						+ (y > 0 && !roadY[y - 1][x] ? dp[y - 1][x] : 0);
			}
		}
		System.out.println(dp[N][M]);
	}
}
