import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] g = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				g[i][0] = Integer.parseInt(st.nextToken());
				g[i][1] = Integer.parseInt(st.nextToken());
			}
			int[] a = new int[L + 1];
			for (int i = 0; i < N; i++) {
				int c = g[i][1];
				for (int j = L; j >= c; j--)
					a[j] = Math.max(a[j], a[j - c] + g[i][0]);
			}
			int m = 0;
			for (int v : a)
				if (v > m)
					m = v;
			sb.append("#" + t + " " + m + "\n");
		}
		System.out.println(sb);
	}
}