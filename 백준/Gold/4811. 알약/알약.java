import java.io.*;

public class Main {
	static long dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new long[31][31]; // [2의 갯수][1의 갯수]
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			sb.append(check(n, 0)).append("\n");
		}
		System.out.println(sb);
	}

	private static long check(int n2, int n1) {
		if (dp[n2][n1] != 0)
			return dp[n2][n1];
		if (n2 == 0) {
			dp[n2][n1] = 1;
		} else {
			if (n1 == 0)
				dp[n2][n1] = check(n2 - 1, 1);
			else
				dp[n2][n1] = check(n2 - 1, n1 + 1) + check(n2, n1 - 1);
		}
		return dp[n2][n1];
	}
}
