import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[n]; // 원소 제거 X
		int dp2[] = new int[n]; // 하나의 원소를 제거하는 경우
		/*
		 * 카데인 알고리즘
		 * dp[i] = max(dp[i-1] + arr[i], arr[i])
		 * 이전dp값+현재값 vs. 현재값
		 * 
		 * dp2[i] = max(dp2[i-1] + arr[i], dp[i-1])
		 * 이전dp2(원소 제거)+현재값 vs. 지금 원소 제거(이전까지의 최댓값)
		 * 
		 * result = max(dp, dp2)
		 */

		dp[0] = arr[0]; 
		dp2[0] = arr[0];
		
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			
			if (i == 1)
				dp2[i] = dp[0];  // arr[1]을 제거할 수 없으므로 그냥 dp[0] 유지
			else
				dp2[i] = Math.max(dp2[i - 1] + arr[i], dp[i - 1]);
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			max = Math.max(max, Math.max(dp[i], dp2[i]));
		System.out.println(max);
	}
}
