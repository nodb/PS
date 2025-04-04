import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		if (k == 0) {
			System.out.println(0);
			return;
		}

		int maxDepth = k + n; // 최대 깊이 : k 출발, n번 내내 아래로 이동
		long[][] dp = new long[n + 1][maxDepth + 1]; // [시간][깊이]

		dp[0][k] = 1; // 초기 상태 : 시간 0에 깊이 k에서 1가지 경우

		for (int i = 0; i < n; i++) {
			for (int pos = 1; pos <= maxDepth; pos++) {
				if (dp[i][pos] != 0) {
					// 위 이동
					if (pos > 1)
						dp[i + 1][pos - 1] += dp[i][pos];
					// 아래 이동
					if (pos < maxDepth)
						dp[i + 1][pos + 1] += dp[i][pos];
				}
			}
		}

		long result = 0;
		for (int pos = 1; pos <= maxDepth; pos++)
			result += dp[n][pos];

		System.out.println(result);
	}
}
