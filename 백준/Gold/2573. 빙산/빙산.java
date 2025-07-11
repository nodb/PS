import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		int time = 0; // 시간
		int cnt = 0; // 빙산 개수
		int arrCopy[][] = new int[N][M];

		while (cnt < 2) {
			time++;
			cnt = 0;

			// 배열 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arrCopy[i][j] = arr[i][j];
				}
			}

			// 녹이기
			// - arr 값이 0이 아니라면
			// - arr -= 사방 0 갯수
			// - arr 최소 : 0
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (arr[y][x] != 0) {
						int zeroCnt = 0;
						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if (nx < 0 || ny < 0 || nx >= M || ny >= N || arrCopy[ny][nx] != 0)
								continue;
							zeroCnt++;
						}
						arr[y][x] = Math.max(arr[y][x] - zeroCnt, 0);
					}
				}
			}

			// 빙산 개수 세기
			boolean visited[][] = new boolean[N][M];
			// BFS
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (arr[y][x] != 0 && !visited[y][x]) {
						cnt++;
						visited[y][x] = true;
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] { x, y });
						while (!q.isEmpty()) {
							int now[] = q.poll();
							int xx = now[0];
							int yy = now[1];
							for (int d = 0; d < 4; d++) {
								int nx = xx + dx[d];
								int ny = yy + dy[d];
								if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == 0 || visited[ny][nx])
									continue;
								visited[ny][nx] = true;
								q.add(new int[] { nx, ny });
							}
						}
					}
				}
			}

			if (cnt == 0) {
				time = 0;
				break;
			}
		}
		System.out.println(time);
	}
}