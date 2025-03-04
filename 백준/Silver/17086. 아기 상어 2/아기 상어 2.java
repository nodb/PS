import java.io.*;
import java.util.*;

public class Main {
	static int n, m, max = 0;
	static int[][] arr, dp;
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					dp[i][j] = 0;
					q.add(new int[] { i, j }); // 상어 위치
				} else {
					dp[i][j] = -1; // 방문 안한 곳
				}
			}
		}

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}

		System.out.println(max);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1];

			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				if (dp[ny][nx] != -1) // 이미 방문한 곳이면 스킵
					continue;

				dp[ny][nx] = dp[y][x] + 1;
				q.add(new int[] { ny, nx });
			}
		}
	}
}
