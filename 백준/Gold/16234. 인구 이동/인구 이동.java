import java.io.*;
import java.util.*;

public class Main {
	static int cnt = -1;
	static int n, l, r;
	static boolean flag;
	static int arr[][], visited[][];
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
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		flag = true;
		visited = new int[n][n];
		while (flag) {
			flag = false;
			cnt++;
			for (int y = 0; y < n; y++)
				Arrays.fill(visited[y], -1);

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (visited[y][x] == -1)
						bfs(x, y);
				}
			}

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					arr[y][x] = visited[y][x];
				}
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		visited[y][x] = -2;
		int sum = 0;
		int init = arr[y][x];
		ArrayList<Pair> list = new ArrayList<>();
		while (!q.isEmpty()) {
			Pair now = q.poll();
			list.add(now);
			int xx = now.x;
			int yy = now.y;
			int value = arr[yy][xx];
			sum += value;
			for (int d = 0; d < 4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx] != -1)
					continue;
				int diff = Math.abs(arr[ny][nx] - value); // 인구 차이
				if (diff < l || diff > r)
					continue;
				visited[ny][nx] = -2;
				q.offer(new Pair(nx, ny));
			}
		}
		if (init != sum)
			flag = true;
		move(list, (int) sum / list.size());
	}

	private static void move(ArrayList<Pair> list, int p) {
		for (Pair now : list) {
			int x = now.x;
			int y = now.y;
			visited[y][x] = p;
		}
	}
}