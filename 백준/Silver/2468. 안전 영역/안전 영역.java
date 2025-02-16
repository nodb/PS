import java.io.*;
import java.util.*;

public class Main {
	static int n, max = 0, cnt, max_cnt = 0;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}

		for (int i = 0; i < max; i++) {
			visited = new boolean[n][n];
			cnt = 0;
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (arr[y][x] <= i || visited[y][x])
						continue;
					dfs(i, x, y);
					cnt++;
				}
			}
			if (cnt > max_cnt) {
				max_cnt = cnt;
			}
		}
		
		System.out.println(max_cnt);

	}

	private static void dfs(int num, int x, int y) {
		visited[y][x] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (arr[ny][nx] <= num || visited[ny][nx])
				continue;
			visited[ny][nx] = true;
			dfs(num, nx, ny);
		}
	}

}
