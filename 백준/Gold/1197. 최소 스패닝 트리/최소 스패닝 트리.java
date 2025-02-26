import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static long min;
	static class Edge implements Comparable<Edge>{
		int s, e, d;
		Edge(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}
		@Override
		public int compareTo(Edge o) { // 거리 순으로 정렬
			return Integer.compare(this.d, o.d);
		}
	}
	static PriorityQueue<Edge> points;
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, d));
		}
		
		/*
		 * <프림 알고리즘>
		 * 1. 임의의 정점을 선택 -> 최초의 트리
		 * 2. 트리에 포함된 정점과 트리에 포함되지 않은 정점 간의 간선 중 가장 작은 가중치를 가지는 간선
		 * 3. 모든 정점이 포함될 때 까지 2를 반복
		 * 
		 * <크루스칼 알고리즘>
		 * 모든 간선의 집합 E
		 * 1. E의 간선 중 가중치가 최소인 간선을 지운다.
		 * 		정렬 사용
		 * 2. 삭제된 간선이 가리리키는 정점 x, y를 연결해도 사이클이 발생하지 않으면 연결
		 * 		Union Find 수행
		 * 3. E가 비어있지 않을 때까지 반복
		 */
		
		// 크루스칼 알고리즘
		makeSet(); // 부분 집합 만들기
		int cnt = 0;
		min = 0L;
		
		while(cnt != V - 1) {
			Edge edge = points.poll();
			if (union(edge.s, edge.e)) {
				cnt++;
				min += edge.d;
			}
		}
		
		System.out.println(min);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) // 조상이 같다면 == 사이클이 생긴다면
			return false;
		// 작은 트리를 큰 트리에 붙여서 트리의 높이를 최소화
		if (rank[x] < rank[y]) { // y가 x의 조상
			rank[y] += rank[x]; // y의 높이 += x의 높이
			parent[x] = y;
		} else { // x가 y의 조상
			rank[x] += rank[y]; // x의 높이 += y의 높이
			parent[y] = x;
		}
		return true;
	}

	static int find(int x) {
		if (x == parent[x])
			return parent[x];
		else
			return parent[x] = find(parent[x]); // 조상을 직접 연결하여 경로 압축
	}
	
	private static void makeSet() {
		parent = new int[V + 1]; // 노드의 조상
		rank = new int[V + 1]; // 노드의 트리 높이, 높이가 높은게 조상
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
}
