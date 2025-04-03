import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			list = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(list);
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());
				sb.append(check(num)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int check(int num) {
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (num == list[mid])
				return 1;
			if (num > list[mid])
				left = mid + 1;
			if (num < list[mid])
				right = mid - 1;
		}
		return 0;
	}
}
