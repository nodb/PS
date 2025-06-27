import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] arr = new char[R][C];
		for (int i = 0; i < R; i++)
			arr[i] = br.readLine().toCharArray();

		Queue<Pair> water = new LinkedList<>();
		Queue<Pair> go = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == '*') {
					water.add(new Pair(i, j));
				} else if (arr[i][j] == 'S') {
					go.add(new Pair(i, j));
					visited[i][j] = true;
				}
			}
		}

		int cnt = 0;
		while (!go.isEmpty()) {
			cnt++;

			// 물 확산
			int waterSize = water.size();
			while (waterSize-- > 0) {
				Pair w = water.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nx = w.x + dx[dir];
					int ny = w.y + dy[dir];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if (arr[nx][ny] == '.') {
						arr[nx][ny] = '*';
						water.add(new Pair(nx, ny));
					}
				}
			}

			// 고슴도치 이동
			int goSize = go.size();
			while (goSize-- > 0) {
				Pair g = go.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nx = g.x + dx[dir];
					int ny = g.y + dy[dir];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny])
						continue;
					// 비버굴 도착
					if (arr[nx][ny] == 'D') {
						System.out.println(cnt);
						return;
					}
					if (arr[nx][ny] == '.') {
						visited[nx][ny] = true;
						go.add(new Pair(nx, ny));
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
}
