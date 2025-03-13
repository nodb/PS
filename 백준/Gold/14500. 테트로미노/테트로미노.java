import java.io.*;
import java.util.*;

public class Main {
	static int N, M, sum, max_sum = 0;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum = 0;
		// 4개 연속
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				FourContinue(j, i, 0);
			}
		}
		// ㅓ ㅏ ㅗ ㅜ 모양
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				OneContinue(j, i);
			}
		}
		System.out.println(max_sum);
	}

	private static void OneContinue(int x, int y) {
		int left = x - 1;
		int right = x + 1;
		int up = y - 1;
		int down = y + 1;
		// ㅓ
		if (left >= 0 && up >= 0 && down < N)
			max_sum = Math.max(max_sum, arr[y][x] + arr[y][left] + arr[up][x] + arr[down][x]);
		// ㅏ
		if (right < M && up >= 0 && down < N)
			max_sum = Math.max(max_sum, arr[y][x] + arr[y][right] + arr[up][x] + arr[down][x]);
		// ㅗ
		if (left >= 0 && right < M && up >= 0)
			max_sum = Math.max(max_sum, arr[y][x] + arr[y][left] + arr[y][right] + arr[up][x]);
		// ㅜ
		if (left >= 0 && right < M && down < N)
			max_sum = Math.max(max_sum, arr[y][x] + arr[y][left] + arr[y][right] + arr[down][x]);
	}

	private static void FourContinue(int x, int y, int cnt) {
		if (cnt == 4) {
			max_sum = Math.max(max_sum, sum);
			return;
		}
		visited[y][x] = true;
		sum += arr[y][x];
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx])
				continue;
			FourContinue(nx, ny, cnt + 1);
		}
		sum -= arr[y][x];
		visited[y][x] = false;
	}
}
