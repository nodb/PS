import java.io.*;
import java.util.*;

public class Main {
	static int n, m, max = 0;
	static int arr[][];
	static int visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int y = 0; y < n; y++) {
			String s = br.readLine();
			for (int x = 0; x < m; x++) {
				arr[y][x] = s.charAt(x) == 'W' ? 0 : 1;
			}
		}
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (arr[y][x] == 1) {
					visited = new int[n][m];
					bfs(x, y);
					max = Math.max(max, max());
				}
			}
		}
		System.out.println(max - 1);
	}

	private static int max() {
		int localMax = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (localMax < visited[y][x])
					localMax = visited[y][x];
			}
		}
		return localMax;
	}

	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		visited[y][x] = 1;
		while (!q.isEmpty()) {
			Pair now = q.poll();
			int xx = now.x;
			int yy = now.y;
			for (int d = 0; d < 4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if (nx < 0 || ny < 0 || nx >= m || ny >= n || arr[ny][nx] == 0 || visited[ny][nx] != 0)
					continue;
				visited[ny][nx] = visited[yy][xx] + 1;
				q.offer(new Pair(nx, ny));
			}
		}
	}
}