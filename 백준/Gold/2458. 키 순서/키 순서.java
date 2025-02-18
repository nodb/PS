import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n, m, cnt;
	static List<Integer> up[], down[];
	static boolean visited_up[], visited_down[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt = 0;

		up = new ArrayList[n + 1];
		down = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			up[i] = new ArrayList<>();
			down[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			up[a].add(b);
			down[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			bfs(i);
		}
		System.out.println(n - cnt);
	}

	private static void bfs(int num) {
		// a->b
		Queue<Integer> q = new LinkedList<>();
		visited_up = new boolean[n + 1];
		for (int i : up[num]) {
			q.offer(i);
			visited_up[i] = true;
		}
		while (!q.isEmpty()) {
			int next = q.poll();
			for (int i : up[next]) {
				if (visited_up[i])
					continue;
				visited_up[i] = true;
				q.offer(i);
			}
		}
		// b->a
		q = new LinkedList<>();
		visited_down = new boolean[n + 1];
		for (int i : down[num]) {
			q.offer(i);
			visited_down[i] = true;
		}
		while (!q.isEmpty()) {
			int next = q.poll();
			for (int i : down[next]) {
				if (visited_down[i])
					continue;
				visited_down[i] = true;
				q.offer(i);
			}
		}
		cal(num);
	}

	private static void cal(int num) {
		for (int i = 1; i <= n; i++) {
			if (i == num)
				continue;
			if (!visited_up[i] && !visited_down[i]) {
				cnt++;
				break;
			}
		}
	}
}
