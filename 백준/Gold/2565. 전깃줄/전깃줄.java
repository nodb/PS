import java.io.*;
import java.util.*;

public class Main {
	public static class Pair implements Comparable<Pair> {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (o.x == x)
				return y - o.x;
			return x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Pair> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pair(x, y));
		}

		Collections.sort(list);
		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = list.get(i).y;

		int dp[] = new int[101];
		Arrays.fill(dp, 501);
		dp[0] = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			int b = Arrays.binarySearch(dp, arr[i]);
			if (b < 0) {
				b = (b * -1) - 1;
				dp[b] = arr[i];
			}
			max = Math.max(max, b);
		}
		System.out.println(n - max);
	}
}
