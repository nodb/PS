import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 200 * 1000 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[a][b] = t;
		}

		for (int kk = 1; kk <= n; kk++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][kk] < INF && arr[kk][j] < INF) {
						arr[i][j] = Math.min(arr[i][j], arr[i][kk] + arr[kk][j]);
					}
				}
			}
		}

		int k = Integer.parseInt(br.readLine());
		int people[] = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++)
			people[i] = Integer.parseInt(st.nextToken());

		int result[] = new int[n + 1];
		Arrays.fill(result, INF);
		for (int city = 1; city <= n; city++) {
			int sum = 0;
			boolean flag = true;

			for (int p : people) {
				if (arr[p][city] == INF || arr[city][p] == INF) {
					flag = false;
					break;
				}
				sum = Math.max(sum, arr[p][city] + arr[city][p]);
			}
			if (flag)
				result[city] = sum;
		}

		int min = INF;
		for (int i = 1; i <= n; i++)
			min = Math.min(min, result[i]);

		for (int i = 1; i <= n; i++)
			if (result[i] == min)
				System.out.print(i + " ");
	}
}
