import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> arr[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		arr = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			arr[first].add(second);
			arr[second].add(first);
		}

		int cnt = 0;
		visited = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	private static void dfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		visited[i] = true;
		for (int j = 0; j < arr[i].size(); j++) {
			if (!visited[arr[i].get(j)]) {
				visited[arr[i].get(j)] = true;
				q.offer(arr[i].get(j));
			}
		}
		while (!q.isEmpty()) {
			int next = q.poll();
			for (int j = 0; j < arr[next].size(); j++) {
				if (!visited[arr[next].get(j)]) {
					visited[arr[next].get(j)] = true;
					q.offer(arr[next].get(j));
				}
			}
		}
	}
}
