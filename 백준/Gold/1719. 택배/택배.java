import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 200 * 1000 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[][][] = new int[2][n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(arr[0][i], INF);
			arr[0][i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[0][a][b] = t;
			arr[1][a][b] = b;
			arr[0][b][a] = t;
			arr[1][b][a] = a;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[0][i][k] < INF && arr[0][k][j] < INF) {
						if (arr[0][i][j] > arr[0][i][k] + arr[0][k][j]) {
							arr[0][i][j] = arr[0][i][k] + arr[0][k][j];
							arr[1][i][j] = arr[1][i][k];							
						}
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					System.out.print("- ");
				else
					System.out.print(arr[1][i][j] + " ");
			}
			System.out.println();
		}
	}
}
