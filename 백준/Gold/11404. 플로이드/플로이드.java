import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100_000 * 100 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(arr[i], MAX);
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.min(arr[a][b], c);
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
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == MAX)
					System.out.print(0 + " ");
				else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
