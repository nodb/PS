import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(br.readLine());
			int sum = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				boolean c1 = check(cx, cy, r, x1, y1);
				boolean c2 = check(cx, cy, r, x2, y2);
				if (c1 | c2 && c1 ^ c2) {
					sum++;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean check(int cx, int cy, int r, int x, int y) {
		// (cx - x)^2 + (cy - y)^2 < r^2이면 원안에 좌표가 포함
		if ((cx - x) * (cx - x) + (cy - y) * (cy - y) < r * r)
			return true;
		else
			return false;
	}
}