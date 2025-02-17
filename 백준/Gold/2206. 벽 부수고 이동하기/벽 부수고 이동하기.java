import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pair {
		int x, y, wall, dist;

		Pair(int x, int y, int wall, int dist) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[2][N][M]; // 벽을 부쉈는지 여부(0: 부순적 X, 1: 부순적 O)

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0, 0, 1)); // (0, 0), 벽을 부순 적 X, 거리 1
		visited[0][0][0] = 1; // 처음 위치 방문 처리

		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			// 끝나는 칸 도착
			if (p.x == M - 1 && p.y == N - 1)
				return p.dist;

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nw = p.wall;
				int nd = p.dist;

				// 경계 넘는 경우 제외
				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				// 이동 가능, 방문 안함
				if (arr[ny][nx] == 0 && visited[nw][ny][nx] == 0) {
					visited[nw][ny][nx] = 1; // 방문 처리
					queue.add(new Pair(nx, ny, nw, nd + 1));
				}

				// 벽이고, 부순 적 X, 방문 안함 -> 한 번 부수기
				if (arr[ny][nx] == 1 && nw == 0 && visited[1][ny][nx] == 0) {
					visited[1][ny][nx] = 1; // 부순 위치 방문 처리
					queue.add(new Pair(nx, ny, 1, nd + 1));
				}
				
				// 벽 부순 적 있다면 제외
			}
		}

		return -1; // 불가능
	}
}
