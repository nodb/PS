import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		char arr[][] = new char[N][M];
		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();
		int cnt[][] = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(cnt[i], Integer.MAX_VALUE);
		cnt[0][0] = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });

		// BFS
		while (!q.isEmpty()) {
			int now[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				// 찾는 값의 기존 cnt > 찾는 값의 현재 cnt(now의 cnt + 0 or 1)
				// - 갱신 & Q에 추가
				// 그외 continue;
				int newCnt = cnt[now[1]][now[0]] + (arr[ny][nx] == '0' ? 0 : 1);
				if (cnt[ny][nx] > newCnt) {
					cnt[ny][nx] = newCnt;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		System.out.println(cnt[N - 1][M - 1]);
	}
}