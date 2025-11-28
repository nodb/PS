import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		for (int y = 0; y < n; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int save[][][] = new int[n][n][3]; // [y][x][방향], 방향 0: 가로, 1: 세로, 2: 대각선
		save[0][1][0] = 1;
		for (int i = 0; i < 2 * n - 1; i++) {
			for (int j = 0; j <= i; j++) {
				int x = i - j;
				int y = j;
				if (x >= n || y >= n)
					continue;
				if (arr[y][x] == 1)
					continue;
				// save[y][x][0]
				if (x - 1 >= 0)
					save[y][x][0] += save[y][x - 1][0] + save[y][x - 1][2];
				// save[y][x][1]
				if (y - 1 >= 0)
					save[y][x][1] += save[y - 1][x][1] + save[y - 1][x][2];
				// save[y][x][2]
				if (x - 1 >= 0 && y - 1 >= 0) {
					if (arr[y][x - 1] == 1 || arr[y - 1][x] == 1 || arr[y - 1][x - 1] == 1)
						continue;
					save[y][x][2] += save[y - 1][x - 1][0] + save[y - 1][x - 1][1] + save[y - 1][x - 1][2];
				}
			}
		}
		System.out.println(save[n - 1][n - 1][0] + save[n - 1][n - 1][1] + save[n - 1][n - 1][2]);
	}
}
