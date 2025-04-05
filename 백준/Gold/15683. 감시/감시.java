import java.io.*;
import java.util.*;

public class Main {
	static int N, M, min = Integer.MAX_VALUE;
	static int arr[][];
	static int visited[][];
	static int dx[] = { -1, 0, 1, 0 }; // 왼, 위, 오, 아
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] != 0)
					visited[y][x]++;
			}
		}
		// 5 : 모든 방향 - 1
		// 1, 3, 4 : 한 방향 - 4
		// 2 : 두 방향 - 2

		// 5 채우기
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (arr[y][x] == 5) {
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						while (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] != 6) {
							if (arr[ny][nx] == 0)
								visited[ny][nx]++;
							nx += dx[d];
							ny += dy[d];
						}
					}
				}
			}
		}
		check(0, 0);
		System.out.println(min);
	}

	private static void check(int x, int y) {
		for (int i = y; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == y && j < x)
					continue;
				if (arr[i][j] == 1) { // 1번 카메라
					for (int d = 0; d < 4; d++) {
						// 채우기
						fill_camera(j, i, d);
						check(j + 1, i);
						// 복구
						delete_camera(j, i, d);
					}
				} else if (arr[i][j] == 2) { // 2번 카메라
					for (int d = 0; d < 2; d++) {
						// 채우기
						fill_camera(j, i, d);
						fill_camera(j, i, d + 2);
						check(j + 1, i);
						// 복구
						delete_camera(j, i, d);
						delete_camera(j, i, d + 2);
					}
				} else if (arr[i][j] == 3) { // 3번 카메라
					for (int d = 0; d < 4; d++) {
						// 채우기
						fill_camera(j, i, d);
						if (d == 3)
							fill_camera(j, i, 0);
						else
							fill_camera(j, i, d + 1);
						check(j + 1, i);
						// 복구
						delete_camera(j, i, d);
						if (d == 3)
							delete_camera(j, i, 0);
						else
							delete_camera(j, i, d + 1);
					}
				} else if (arr[i][j] == 4) { // 4번 카메라
					for (int d = 0; d < 4; d++) {
						// 채우기
						fill_camera(j, i, d);
						if (d >= 3)
							fill_camera(j, i, d - 3);
						else
							fill_camera(j, i, d + 1);
						if (d >= 2)
							fill_camera(j, i, d - 2);
						else
							fill_camera(j, i, d + 2);
						check(j + 1, i);
						// 복구
						delete_camera(j, i, d);
						if (d >= 3)
							delete_camera(j, i, d - 3);
						else
							delete_camera(j, i, d + 1);
						if (d >= 2)
							delete_camera(j, i, d - 2);
						else
							delete_camera(j, i, d + 2);
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0) {
					sum++;
				}
			}
		}
		min = Math.min(min, sum);
	}

	private static void fill_camera(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] != 6) {
			visited[ny][nx]++;
			nx += dx[d];
			ny += dy[d];
		}
	}

	private static void delete_camera(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] != 6) {
			visited[ny][nx]--;
			nx += dx[d];
			ny += dy[d];
		}
	}
}
