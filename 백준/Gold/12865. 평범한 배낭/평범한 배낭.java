import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		int arr[][] = new int[N][2];
		int dp[] = new int[K + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 각 물건의 무게
			arr[i][1] = Integer.parseInt(st.nextToken()); // 각 물건의 가치
		}
		for (int i = 0; i < N; i++) {
			int W = arr[i][0];
			int V = arr[i][1];
			for (int j = K - W; j >= 0; j--) {
				dp[j + W] = Math.max(dp[j] + V, dp[j + W]);
			}
		}
		System.out.println(dp[K]);
	}
}