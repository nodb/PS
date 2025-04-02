import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double arr[] = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		double dp[] = new double[n];
		dp[0] = arr[0];
		double max = 0;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(arr[i], arr[i] * dp[i - 1]);
			max = Math.max(max, dp[i]);
		}
		System.out.printf("%.3f", max);
	}
}
