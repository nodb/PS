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
				if (arr[99][i] == 2) {
					System.out.println("#" + testcase + " " + cal(i));
				}
			}
		}
	}

	private static int cal(int num) {
		int x = num;
		for (int y = 99; y >= 0; y--) {
			if (x - 1 >= 0 && arr[y][x - 1] == 1) {
				while (x - 1 >= 0 && arr[y][x - 1] == 1) {
					x--;
				}
			} else if (x + 1 < 100 && arr[y][x + 1] == 1) {
				while (x + 1 < 100 && arr[y][x + 1] == 1) {
					x++;
				}
			}
		}
		return x;
	}
}