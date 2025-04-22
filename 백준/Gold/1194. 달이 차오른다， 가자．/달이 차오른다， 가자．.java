import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class State {
		int x, y, keys, steps;

		public State(int x, int y, int keys, int steps) {
			this.x = x;
			this.y = y;
			this.keys = keys;
			this.steps = steps;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		int startX = 0, startY = 0;

		for (int y = 0; y < n; y++) {
			map[y] = br.readLine().toCharArray();
			for (int x = 0; x < m; x++) {
				if (map[y][x] == '0') {
					startX = x;
					startY = y;
				}
			}
		}

		visited = new boolean[1 << 6][n][m]; // 6개의 키 상태(2^6 = 64)
		System.out.println(bfs(startX, startY));
	}

	static int bfs(int startX, int startY) {
		Queue<State> q = new LinkedList<>();
		q.add(new State(startX, startY, 0, 0));
		visited[0][startY][startX] = true;

		while (!q.isEmpty()) {
			State cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				int key = cur.keys;

				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				char ch = map[ny][nx];

				if (ch == '#')
					continue;

				// 문인 경우 (A~F), 열쇠가 없으면 못 지나감
				if (ch >= 'A' && ch <= 'F') {
					int door = ch - 'A';
					if ((key & (1 << door)) == 0)
						continue;
				}

				// 열쇠인 경우 (a~f), 획득
				if (ch >= 'a' && ch <= 'f') {
					key |= (1 << (ch - 'a'));
				}

				if (visited[key][ny][nx])
					continue;
				visited[key][ny][nx] = true;

				if (ch == '1')
					return cur.steps + 1;

				q.add(new State(nx, ny, key, cur.steps + 1));
			}
		}
		return -1;
	}
}
