import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[102][102];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int xx = x; xx < x + 10; xx++) {
				for (int yy = y; yy < y + 10; yy++) {
					arr[yy][xx] = 1;
				}
			}
		}
//		for (int i = 1; i <= 100; i++) {
//			for (int j = 1; j <= 100; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		int cnt = 0;
		for (int y = 0; y <= 100; y++) {
			for (int x = 0; x <= 100; x++) {
				if (arr[y][x] != arr[y][x + 1]) {
					cnt++;
				}
				if (arr[y][x] != arr[y + 1][x]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
