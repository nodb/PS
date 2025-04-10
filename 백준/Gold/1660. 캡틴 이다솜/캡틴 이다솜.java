import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());

		List<Integer> list = new ArrayList<>();
		for (int i = 1;; i++) { // 사면체 수 = i*(i+1)*(i+2)/6
			int t = i * (i + 1) * (i + 2) / 6;
			if (t > n)
				break;
			list.add(t);
		}

		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i : list) {
			for (int j = i; j <= n; j++) {
				if (dp[j - i] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - i] + 1);
				}
			}
		}
		System.out.println(dp[n]);
	}
}
