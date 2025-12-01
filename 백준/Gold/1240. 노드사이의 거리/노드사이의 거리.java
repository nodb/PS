import java.io.*;
import java.util.*;

public class Main {

	static class Pair {
		int node;
		int d;

		Pair(int node, int d) {
			this.node = node;
			this.d = d;
		}
	}

	static List<Pair> list[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list[a].add(new Pair(b, d));
			list[b].add(new Pair(a, d));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			visited = new boolean[n + 1];
			int dist = bfs(start, end);
			sb.append(dist).append('\n');
		}

		System.out.print(sb);
	}

	static int bfs(int start, int end) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int now[] = q.remove();
			int num = now[0];
			int dist = now[1];

			if (num == end) {
				return dist;
			}

			for (Pair next : list[num]) {
				if (!visited[next.node]) {
					visited[next.node] = true;
					q.add(new int[] { next.node, dist + next.d });
				}
			}
		}
		return -1;
	}
}
