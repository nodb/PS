import java.io.*;
import java.util.*;

public class Main {

	// 인접 리스트용 간선 구조체 (to: 도착 정점, dis: 가중치)
	static class Graph {
		int toV;
		int dis;

		Graph(int toV, int dis) {
			this.toV = toV;
			this.dis = dis;
		}
	}

	// 우선순위큐에 들어갈 노드 (v: 정점, dis: 시작점~정점까지의 현재 최단 추정거리)
	static class Node implements Comparable<Node> {
		int v;
		int dis;

		Node(int v, int dis) {
			this.v = v;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			// 거리 오름차순 (가장 짧은 거리부터 꺼내기)
			return Integer.compare(this.dis, o.dis);
		}
	}

	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// V: 정점 수, E: 간선 수
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// K: 시작 정점
		int K = Integer.parseInt(br.readLine());

		// 인접 리스트
		List<Graph>[] list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<>();

		// 간선 입력 (u -> v, 가중치 w)
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Graph(v, w));
		}

		// 최단거리 배열 초기화
		int[] min = new int[V + 1];
		Arrays.fill(min, INF);
		min[K] = 0;

		// 다익스트라: (거리, 정점) 최소 힙
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			// 스테일 노드(이미 더 짧은 거리로 확정된 후 뒤늦게 나온 노드)면 스킵
			if (cur.dis > min[cur.v])
				continue;

			// 간선 완화
			for (Graph g : list[cur.v]) {
				int nd = cur.dis + g.dis;
				if (nd < min[g.toV]) { // 더 짧은 경로 발견 시
					min[g.toV] = nd; // 갱신
					pq.add(new Node(g.toV, nd)); // PQ에 푸시
				}
			}
		}

		// 출력: 도달 불가면 INF
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(min[i] == INF ? "INF" : String.valueOf(min[i])).append('\n');
		}
		System.out.print(sb.toString());
	}
}
