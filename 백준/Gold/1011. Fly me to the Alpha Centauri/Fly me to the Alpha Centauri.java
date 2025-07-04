import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = y - x;

			int n = (int) Math.sqrt(d);

			// 이동횟수 - 2n
			// n^2 < d <= n(n+1)
			// 이동횟수 - 2n + 1
			// n(n+1) < d <= (n+1)^2
			if (n * n == d)
				System.out.println(2 * n - 1);
			else if (d <= n * (n + 1))
				System.out.println(2 * n);
			else
				System.out.println(2 * n + 1);
		}
	}
}
