import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

	static int dxx[] = { -1, -1, 1, 1 };
	static int dyy[] = { -1, 1, -1, 1 };

	static class Func {
		int x, y;

		Func(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Func other = (Func) obj;
			return x == other.x && y == other.y;
		}
	}

	static HashSet<Func> hs = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Func> q = new LinkedList<>();
		q.add(new Func(0, N - 1));
		q.add(new Func(0, N - 2));
		q.add(new Func(1, N - 1));
		q.add(new Func(1, N - 2));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); // 방향
			int s = Integer.parseInt(st.nextToken()); // 거리

			Queue<Func> temp = new LinkedList<>();
			// 구름이 있는 칸에 비가 1씩 내리기
			while (!q.isEmpty()) {
				Func qxy = q.remove();
				int qx = qxy.x;
				int qy = qxy.y;
				int nx = dx[d] * s;
				int ny = dy[d] * s;
				int rx = (qx + nx + N * 50) % N;
				int ry = (qy + ny + N * 50) % N;
				arr[ry][rx]++;
				temp.add(new Func(rx, ry));
				hs.add(new Func(rx, ry));
			}
			// 대각선 확인
			while (!temp.isEmpty()) {
				Func qxy = temp.remove();
				int qx = qxy.x;
				int qy = qxy.y;
				for (int dir = 0; dir < 4; dir++) {
					int nx = qx + dxx[dir];
					int ny = qy + dyy[dir];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (arr[ny][nx] != 0) {
						arr[qy][qx]++;
					}
				}
			}
			// 2이상 확인 후 q에 넣기
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (arr[y][x] >= 2 && !hs.contains(new Func(x, y))) {
						arr[y][x] -= 2;
						q.add(new Func(x, y));
					}
				}
			}

			hs.clear();
		}
		int cnt = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				cnt += arr[y][x];
			}
		}
		System.out.println(cnt);
	}
}
