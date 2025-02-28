import java.io.*;
import java.util.*;

public class Main {
	static int r, c, t, arr[][], tmp[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		int air = 0;
		for (int y = 0; y < r; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < c; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == -1) {
					air = y;
				}
			}
		}

		for (int tc = 0; tc < t; tc++) {
			// 미세먼지 확산
			tmp = new int[r][c];
			for (int y = 0; y < r; y++) {
				for (int x = 0; x < c; x++) {
					if (arr[y][x] == -1) { // 공기청정기
						tmp[y][x] = -1;
						continue;
					}
					int possible_cnt = 0; // 4방향 중 가능 횟수
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx < 0 || ny < 0 || nx >= c || ny >= r)
							continue;
						if (arr[ny][nx] == -1) // 공기청정기
							continue;
						tmp[ny][nx] += arr[y][x] / 5;
						possible_cnt++;
					}
					tmp[y][x] += arr[y][x] - (arr[y][x] / 5 * possible_cnt);
				}
			}
			// 배열 덮어씌우기
			for (int y = 0; y < r; y++) {
				for (int x = 0; x < c; x++) {
					arr[y][x] = tmp[y][x];
				}
			}

			// 미세먼지 돌리기
			// 위쪽
			// 위쪽_왼쪽
			for (int y = air - 2; y > 0; y--) {
				arr[y][0] = arr[y - 1][0];
			}
			// 위쪽_위쪽
			for (int x = 0; x < c - 1; x++) {
				arr[0][x] = arr[0][x + 1];
			}
			// 위쪽_오른쪽
			for (int y = 0; y < air - 1; y++) {
				arr[y][c - 1] = arr[y + 1][c - 1];
			}
			// 위쪽_아래쪽
			for (int x = c - 1; x > 1; x--) {
				arr[air - 1][x] = arr[air - 1][x - 1];
			}
			arr[air - 1][1] = 0;

			// 아래쪽
			// 아래쪽_왼쪽
			for (int y = air + 1; y < r - 1; y++) {
				arr[y][0] = arr[y + 1][0];
			}
			// 아래쪽_아래쪽
			for (int x = 0; x < c - 1; x++) {
				arr[r - 1][x] = arr[r - 1][x + 1];
			}
			// 아래쪽_오른쪽
			for (int y = r - 1; y > air; y--) {
				arr[y][c - 1] = arr[y - 1][c - 1];
			}
			// 아래쪽_위쪽
			for (int x = c - 1; x > 1; x--) {
				arr[air][x] = arr[air][x - 1];
			}
			arr[air][1] = 0;
		}

//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 미세먼지 양 세기
		int cnt = 2;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cnt += arr[i][j];
			}
		}
		System.out.println(cnt);
	}
}