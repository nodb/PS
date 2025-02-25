import java.io.*;
import java.util.*;

public class Main {
	static int n, max = 0;
	static int arr[][];
	static int dp[][];
	static boolean visited[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[n][n];
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(j, i);
			}
		}

		System.out.println(max);
	}

	private static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (arr[ny][nx] > arr[y][x]) { // 방문하는 곳이 더 크다면
				if (!visited[ny][nx]) { // 아직 방문하지 않은 경우 : dp 갱신
					visited[ny][nx] = true;
					dfs(nx, ny);
				}
				// 이미 방문한 경우 or 위에서 방문한 경우 : dp가 이미 최댓값
				if (dp[y][x] < dp[ny][nx] + 1) {
					dp[y][x] = dp[ny][nx] + 1;
				}
			}
		}
		if (max < dp[y][x] + 1) {
			max = dp[y][x] + 1;
		}
	}
}

//4
//14 9 12 10
//1 11 5 4
//7 15 2 13
//6 3 16 8

//0 2 0 1
//2 1 2 3
//1 0 3 0
//2 3 0 1