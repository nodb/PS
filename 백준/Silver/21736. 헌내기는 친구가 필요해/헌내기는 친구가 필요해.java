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

		char arr[][] = new char[N][M];
		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();

		int I[] = new int[2];
		func: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'I') {
					I[0] = j;
					I[1] = i;
					break func;
				}
			}
		}

		// bfs
		boolean visited[][] = new boolean[N][M];
		visited[I[1]][I[0]] = true;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { I[0], I[1] });

		int cnt = 0;

		while (!q.isEmpty()) {
			int now[] = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == 'X' || visited[ny][nx])
					continue;

				if (arr[ny][nx] == 'P')
					cnt++;

				visited[ny][nx] = true;
				q.add(new int[] { nx, ny });
			}
		}
		System.out.println(cnt == 0 ? "TT" : cnt);
	}

}