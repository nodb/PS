import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100 * 100 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int item[] = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			item[i] = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(arr[i], MAX);

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			arr[a][b] = I;
			arr[b][a] = I;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= n; j++) {
					if (k == j)
						continue;
					if (i == j) {
						arr[i][j] = 0;
						continue;
					}
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		int result = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] <= m) {
					sum += item[j];
				}
			}
			result = Math.max(result, sum);
		}
		System.out.println(result);
	}
}
