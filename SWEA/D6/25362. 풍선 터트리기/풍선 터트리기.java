import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			long[] arr = new long[N + 2]; // 1-indexed 사용, 양끝 여유

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				arr[i] = Long.parseLong(st.nextToken());

			// dp[l][r]: l..r 구간의 풍선을 모두 터뜨릴 때 얻을 수 있는 최대 점수
			long[][] dp = new long[N + 2][N + 2];

			for (int len = 1; len <= N; len++) {
				for (int l = 1; l + len - 1 <= N; l++) {
					int r = l + len - 1;
					long best = 0;
					for (int i = l; i <= r; i++) {
						long left = (l > 1) ? arr[l - 1] : 0; // 바깥 왼쪽 이웃 (남아 있음)
						long right = (r < N) ? arr[r + 1] : 0; // 바깥 오른쪽 이웃 (남아 있음)

						long gain;
						if (l == 1 && r == N) {
							// 전체 마지막 풍선이 i
							gain = arr[i];
						} else if (l > 1 && r < N) {
							gain = left * right;
						} else if (l == 1) { // r < N
							gain = right;
						} else { // l > 1 && r == N
							gain = left;
						}

						long cand = dp[l][i - 1] + dp[i + 1][r] + gain;
						if (cand > best)
							best = cand;
					}
					dp[l][r] = best;
				}
			}

			sb.append('#').append(tc).append(' ').append(dp[1][N]).append('\n');
		}
		System.out.print(sb.toString());
	}
}
