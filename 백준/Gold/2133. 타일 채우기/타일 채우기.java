import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N % 2 != 0) {
			System.out.println(0);
			return;
		}
		N /= 2;
		int dp[] = new int[N + 1];
		dp[1] = 3;
		for (int i = 2; i <= N; i++) {
			int sum = 2 + 3 * dp[i - 1];
			for (int j = i - 2; j > 0; j--) {
				sum += 2 * dp[j];
			}
			dp[i] = sum;
		}
		System.out.println(dp[N]);
	}
}