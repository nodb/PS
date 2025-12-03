import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x, y, k;
	static int arr[][];
	static int dice[] = new int[7];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			// 동쪽 1
			if (cmd == 1) {
				if (x == m - 1)
					continue;
				right();
			}
			// 서쪽 2
			else if (cmd == 2) {
				if (x == 0)
					continue;
				left();
			}
			// 북쪽 3
			else if (cmd == 3) {
				if (y == 0)
					continue;
				up();
			}
			// 남쪽은 4
			else if (cmd == 4) {
				if (y == n - 1)
					continue;
				down();
			}
		}
		System.out.println(sb);
	}

	static void right() {
		int temp = dice[1];
		dice[1] = dice[4];
		dice[4] = dice[6];
		dice[6] = dice[3];
		dice[3] = temp;
		x++;
		check();
	}

	static void left() {
		int temp = dice[1];
		dice[1] = dice[3];
		dice[3] = dice[6];
		dice[6] = dice[4];
		dice[4] = temp;
		x--;
		check();
	}

	static void up() {
		int temp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[6];
		dice[6] = dice[2];
		dice[2] = temp;
		y--;
		check();
	}

	static void down() {
		int temp = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[6];
		dice[6] = dice[5];
		dice[5] = temp;
		y++;
		check();
	}

	private static void check() {
		if (arr[y][x] == 0) {
			arr[y][x] = dice[6];
		} else {
			dice[6] = arr[y][x];
			arr[y][x] = 0;
		}
		sb.append(dice[1] + "\n");
	}
}
