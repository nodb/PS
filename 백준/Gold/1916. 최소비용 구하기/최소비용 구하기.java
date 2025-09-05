import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int num;
		int cost;

		Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int dist[] = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		List<Node> list[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[start] = 0;
		q.add(new Node(start, 0));
		
		while (!q.isEmpty()) {
			Node now = q.remove();
			if (dist[now.num] < now.cost) continue;
			
			for (Node next : list[now.num]) {
				int nextcost = now.cost + next.cost;
				if (nextcost < dist[next.num]) {
					dist[next.num] = nextcost;
					q.add(new Node(next.num, nextcost));
				}
			}
		}
		System.out.println(dist[end]);
	}
}
