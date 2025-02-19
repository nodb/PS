import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 1) {
				System.out.println("#" + tc);
				System.out.println(1);
				continue;
			}
			int arr[][] = new int[n][n];
			int cnt = 1;
			int size = n;
			for (int i = 0; i < size; i++) {
				arr[0][i] = cnt++;
			}

			size--;
			int x = size;
			int y = 0;

			while (true) {
				for (int i = 0; i < size; i++) {
					arr[++y][x] = cnt++;
				}
				for (int i = 0; i < size; i++) {
					arr[y][--x] = cnt++;
				}
				size--;
				if (size == 0)
					break;
				for (int i = 0; i < size; i++) {
					arr[--y][x] = cnt++;
				}
				for (int i = 0; i < size; i++) {
					arr[y][++x] = cnt++;
				}
				size--;
				if (size == 0)
					break;
			}
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
