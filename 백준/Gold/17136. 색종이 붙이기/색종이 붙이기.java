import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	static int min = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int paper[] = new int[6];
		for (int i = 0; i < 6; i++)
			paper[i] = 5;

		arr = new int[10][10];
		for (int y = 0; y < 10; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < 10; x++)
				arr[y][x] = Integer.parseInt(st.nextToken());
		}

		func(0, 5, 5, 5, 5, 5);

		System.out.println(min == 100 ? -1 : min);
	}

	private static void func(int cnt, int P1, int P2, int P3, int P4, int P5) {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (arr[y][x] == 1) {
					if (P5 != 0)
						check(x, y, 5, cnt, P1, P2, P3, P4, P5 - 1);
					if (P4 != 0)
						check(x, y, 4, cnt, P1, P2, P3, P4 - 1, P5);
					if (P3 != 0)
						check(x, y, 3, cnt, P1, P2, P3 - 1, P4, P5);
					if (P2 != 0)
						check(x, y, 2, cnt, P1, P2 - 1, P3, P4, P5);
					if (P1 != 0)
						check(x, y, 1, cnt, P1 - 1, P2, P3, P4, P5);
					return;
				}
			}
		}
		if (cnt < min)
			min = cnt;
	}

	private static void check(int x, int y, int n, int cnt, int P1, int P2, int P3, int P4, int P5) {
		if (x + n - 1 < 10 && y + n - 1 < 10) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (arr[y + i][x + j] == 0)
						return;
			// 가능하면
			// 0으로 만들기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[y + i][x + j] = 0;
				}
			}
			func(cnt + 1, P1, P2, P3, P4, P5);
			// 1로 복귀
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[y + i][x + j] = 1;
				}
			}
		}
		return;
	}
}