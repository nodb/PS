import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr1[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				arr2[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr1);
			Arrays.sort(arr2);

			int sum = 0;
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				while (cnt < m && arr2[cnt] < arr1[i])
					cnt++;
				sum += cnt;
			}

			sb.append(sum).append('\n');
		}
		System.out.print(sb);
	}
}
