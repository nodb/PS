import java.io.*;
import java.util.*;

public class Main {
	static final int dx[] = { -1, 1, 0, 0 };
	static final int dy[] = { 0, 0, -1, 1 };

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

		// visited[y][x][broken] : (y, x)에 벽 broken개 부수고 도달했을 때의 이동 칸 수
		int visited[][][] = new int[N][M][K + 1];
		Queue<int[]> q = new LinkedList<>();
		visited[0][0][0] = 1;
		q.add(new int[] { 0, 0, 0 }); // y, x, broken

		while (!q.isEmpty()) {
			int now[] = q.remove();
			int y = now[0];
			int x = now[1];
			int broken = now[2];

			if (y == N - 1 && x == M - 1) {
				System.out.println(visited[y][x][broken]);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;

				// 빈 칸으로 이동
				if (arr[ny][nx] == 0) {
					if (visited[ny][nx][broken] == 0) {
						visited[ny][nx][broken] = visited[y][x][broken] + 1;
						q.add(new int[] { ny, nx, broken });
					}
				}
				// 벽이면서 아직 더 부술 수 있는 경우
				else if (broken < K && visited[ny][nx][broken + 1] == 0) {
					visited[ny][nx][broken + 1] = visited[y][x][broken] + 1;
					q.add(new int[] { ny, nx, broken + 1 });
				}
			}
		}
		System.out.println(-1);
	}
}
