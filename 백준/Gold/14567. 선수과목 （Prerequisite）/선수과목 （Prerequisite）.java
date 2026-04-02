import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> front[];
	static ArrayList<Integer> back[];
	static int result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		front = new ArrayList[n + 1];
		result = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			front[i] = new ArrayList<>();
			result[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			front[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			result[i] = max(i);
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(result[i] + " ");
		}

	}

	static int max(int i) {
		if (front[i].isEmpty())
			return 1;
		int m = 0;
		for (int j : front[i]) {
			if (result[j] == Integer.MAX_VALUE)
				m = Integer.max(m, max(j) + 1);
			else
				m = Integer.max(m, result[j] + 1);
		}
		return m;
	}
}
