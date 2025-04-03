import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println("*");
			return;
		}
		int R = 4 * N - 1;
		int C = 4 * N - 3;
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(arr[i], ' ');
		}

		pattern(0, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			int last = C - 1;
			while (last >= 0 && arr[i][last] == ' ') {
				last--;
			}
			for (int j = 0; j <= last; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static void pattern(int x, int y, int n) {
		int r = 4 * n - 1;
		int c = 4 * n - 3;

		for (int j = y; j < y + c; j++)
			arr[x][j] = '*';
		for (int j = y; j < y + c; j++)
			arr[x + r - 1][j] = '*';
		for (int i = x; i < x + r; i++)
			arr[i][y] = '*';
		if (n == 1)
			return;
		for (int i = x + 2; i < x + r - 1; i++)
			arr[i][y + c - 1] = '*';

		for (int j = y + 2; j < y + c - 1; j++)
			arr[x + 2][j] = '*';
		pattern(x + 2, y + 2, n - 1);
		for (int i = x + 3; i < x + r - 2; i++)
			arr[i][y + 2] = '*';
	}
}
