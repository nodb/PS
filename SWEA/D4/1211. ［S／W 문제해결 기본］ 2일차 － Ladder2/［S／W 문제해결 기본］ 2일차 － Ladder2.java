import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int arr[][];
	static int min_line;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int testcase = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			min_line = 0;
			min = 10000;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				if (arr[0][i] == 1) {
					cal(i);
				}
			}
			System.out.println("#" + testcase + " " + min_line);
		}
	}

	private static void cal(int num) {
		int cnt = 0;
		int x = num;
		for (int y = 0; y < 100; y++) {
			if (x - 1 >= 0 && arr[y][x - 1] == 1) {
				while (x - 1 >= 0 && arr[y][x - 1] == 1) {
					x--;
					cnt++;
				}
			} else if (x + 1 < 100 && arr[y][x + 1] == 1) {
				while (x + 1 < 100 && arr[y][x + 1] == 1) {
					x++;
					cnt++;
				}
			}
			cnt++;
		}
//		System.out.println(num + " " + cnt);
		if (min > cnt) {
			min = cnt;
			min_line = num;
		}
	}
}