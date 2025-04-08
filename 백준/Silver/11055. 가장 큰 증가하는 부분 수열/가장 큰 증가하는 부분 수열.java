import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int arr[] = new int[a];
		int dp[] = new int[a];
		Arrays.fill(dp, 1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
			}
		}
		
		int max = 0;
		for (int i = 0; i < a; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}