import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];
		for (int y = 0; y < N; y++) {
			char c[] = br.readLine().toCharArray();
			for (int x = 0; x < M; x++)
				arr[y][x] = c[x] - '0';
		}

		// visited[y][x][broken][day], day: 0=낮, 1=밤
		int visited[][][][] = new int[N][M][K + 1][2];

		Queue<int[]> q = new ArrayDeque<>();
		visited[0][0][0][0] = 1; // 시작: (0,0), 부순 벽 0, 낮, 거리 1
		q.add(new int[] { 0, 0, 0, 0 }); // x, y, k, day

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0];
			int y = cur[1];
			int k = cur[2];
			int day = cur[3];
			int dist = visited[y][x][k][day];

			// 목적지 도달
			if (x == M - 1 && y == N - 1) {
				System.out.println(dist);
				return;
			}

			int nextDay = day ^ 1;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				// 벽 X
				if (arr[ny][nx] == 0) {
					// 방문한 적 X
					if (visited[ny][nx][k][nextDay] == 0) {
						visited[ny][nx][k][nextDay] = dist + 1;
						q.add(new int[] { nx, ny, k, nextDay });
					}
				}
				// 벽 O
				else {
					// 낮
					if (k < K && day == 0) {
						if (visited[ny][nx][k + 1][1] == 0) {
							visited[ny][nx][k + 1][1] = dist + 1; // 밤으로 전환
							q.add(new int[] { nx, ny, k + 1, 1 });
						}
					}
				}
			}

			// 밤 : 대기 -> 낮으로 전환
			if (day == 1) {
				if (visited[y][x][k][0] == 0) {
					visited[y][x][k][0] = dist + 1;
					q.add(new int[] { x, y, k, 0 });
				}
			}
		}

		System.out.println(-1);
	}
}
