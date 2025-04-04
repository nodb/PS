import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int arr[][];
	static boolean visited[][];
	static int startx, starty, endx, endy;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static boolean flag = true;
	static int cnt = 0;

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

		st = new StringTokenizer(br.readLine());
		starty = Integer.parseInt(st.nextToken()) - 1;
		startx = Integer.parseInt(st.nextToken()) - 1;
		endy = Integer.parseInt(st.nextToken()) - 1;
		endx = Integer.parseInt(st.nextToken()) - 1;

		for (int y = 0; y < n; y++) {
			String s = br.readLine();
			for (int x = 0; x < m; x++) {
				arr[y][x] = s.charAt(x) == '0' ? 0 : s.charAt(x) == '1' ? 1 : 2;
			}
		}

		while (flag) {
			cnt++;
			visited = new boolean[n][m];
			bfs();
		}

		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(startx, starty));
		visited[starty][startx] = true;
		while (!q.isEmpty()) {
			Pair now = q.poll();
			int xx = now.x;
			int yy = now.y;
			for (int d = 0; d < 4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx])
					continue;
				if (arr[ny][nx] == 2) {
					flag = false;
					return;
				} else if (arr[ny][nx] == 1) {
					visited[ny][nx] = true;
					arr[ny][nx] = 0;
				} else if (arr[ny][nx] == 0) {
					visited[ny][nx] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}
}