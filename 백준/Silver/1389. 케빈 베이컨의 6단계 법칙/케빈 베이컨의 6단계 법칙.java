import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 5000 * 100 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(arr[i], MAX);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= n; j++) {
					if (k == j)
						continue;
					if (i == j)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		int result = MAX;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == MAX)
					continue;
				else
					sum += arr[i][j];
			}
			if (sum < result) {
				result = sum;
				cnt = i;
			}
		}
		System.out.println(cnt);
	}
}
