import java.io.*;
import java.util.*;

public class Main {
	static int city[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine()); // 도시 수
		int M = Integer.parseInt(br.readLine()); // 여행 계획 도시 수
		city = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			city[i] = i;
		}
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		for (int i = 0; i < M - 1; i++) {
			int nextRoot = Integer.parseInt(st.nextToken());
			if (root != find(nextRoot)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB)
			city[rootB] = rootA;
	}

	private static int find(int i) {
		if (city[i] != i)
			city[i] = find(city[i]);
		return city[i];
	}
}
