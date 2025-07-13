import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];
		int result[][] = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(result[i], -1);

		int start[] = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					result[i][j] = 0;
				else if (arr[i][j] == 2) {
					start[0] = j;
					start[1] = i;
				}
			}
		}

		// BFS
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start[0], start[1], 0 }); // x, y, cnt
		result[start[1]][start[0]] = 0;
		arr[start[1]][start[0]] = 0; // 방문시 0

		while (!q.isEmpty()) {
			int now[] = q.poll();
			int x = now[0];
			int y = now[1];
			int cnt = now[2];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == 0)
					continue;

				result[ny][nx] = cnt + 1;
				arr[ny][nx] = 0; // 방문시 0
				q.add(new int[] { nx, ny, cnt + 1 });
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
