import java.io.*;
import java.util.*;

public class Main {
	static int n, m, r, arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		rotate(); // 배열 회전 수행

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void rotate() {
		int layers = Math.min(n, m) / 2; // 회전할 레이어 개수

		for (int layer = 0; layer < layers; layer++) {
			int height = n - 2 * layer; // 현재 레이어의 높이
			int width = m - 2 * layer; // 현재 레이어의 너비
			int perimeter = 2 * (height + width) - 4; // 한 바퀴 돌리는 데 필요한 원소 개수
			int rotations = r % perimeter; // 불필요한 회전을 줄이기 위해 % 연산 사용

			for (int i = 0; i < rotations; i++) {
				int up = layer;
				int down = n - 1 - layer;
				int left = layer;
				int right = m - 1 - layer;

				int first_value = arr[up][left];

				// 위쪽 줄 이동
				for (int x = left; x < right; x++) {
					arr[up][x] = arr[up][x + 1];
				}
				// 오른쪽 줄 이동
				for (int y = up; y < down; y++) {
					arr[y][right] = arr[y + 1][right];
				}
				// 아래쪽 줄 이동
				for (int x = right; x > left; x--) {
					arr[down][x] = arr[down][x - 1];
				}
				// 왼쪽 줄 이동
				for (int y = down; y > up; y--) {
					arr[y][left] = arr[y - 1][left];
				}
				arr[up + 1][left] = first_value; // 첫 번째 값 복원
			}
		}
	}
}
