import java.io.*;
import java.util.*;

public class Main {
	static int n, m, X, Y;
	static ArrayList arr[];

	static class Pair {
		int num, cnt;

		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			arr[first].add(second);
			arr[second].add(first);
		}
		System.out.println(bfs() + 1);
	}

	private static int bfs() {
		boolean visited[] = new boolean[n + 1];
		Queue<Pair> q = new LinkedList<>();
		visited[X] = true;
		for (int i = 0; i < arr[X].size(); i++)
			q.offer(new Pair((int) arr[X].get(i), 0));

		while (!q.isEmpty()) {
			Pair now = q.poll();
			int num = now.num;
			int cnt = now.cnt;
			if (num == Y)
				return cnt;
			if (visited[num])
				continue;
			visited[num] = true;
			for (int i = 0; i < arr[num].size(); i++) {
				if (visited[(int) arr[num].get(i)])
					continue;
				q.offer(new Pair((int) arr[num].get(i), cnt + 1));
			}
		}
		return -2;
	}
}
