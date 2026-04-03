import java.io.*;
import java.util.*;

public class Main {

	// Union-Find 부모 배열
	static int[] parent;

	// 좌표 저장용 클래스
	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 간선 클래스 (Kruskal용)
	static class Edge implements Comparable<Edge> {
		int from; // 시작 정점
		int to; // 끝 정점
		double d; // 거리(가중치)

		Edge(int from, int to, double d) {
			this.from = from;
			this.to = to;
			this.d = d;
		}

		// 거리 기준 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.d, o.d);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 우주신 개수
		int m = Integer.parseInt(st.nextToken()); // 이미 연결된 통로 수

		// 1. Union-Find 초기화 (각자 자기 자신이 부모)
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		// 2. 좌표 입력
		Pair[] point = new Pair[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[i] = new Pair(x, y);
		}

		// 3. 이미 연결된 간선 → Union 처리
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		// 4. 모든 정점 쌍의 간선 생성
		List<Edge> edge = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				// 거리 계산 (유클리드 거리)
				long dx = point[i].x - point[j].x;
				long dy = point[i].y - point[j].y;
				double d = Math.sqrt(dx * dx + dy * dy);

				edge.add(new Edge(i, j, d));
			}
		}

		// 5. 거리 기준으로 정렬 (Kruskal 핵심)
		Collections.sort(edge);

		double result = 0;

		// 6. Kruskal 알고리즘
		for (Edge e : edge) {
			// 서로 다른 집합일 때만 연결
			if (find(e.from) != find(e.to)) {
				union(e.from, e.to);
				result += e.d; // 비용 추가
			}
		}

		// 7. 소수 둘째 자리 출력 (반올림)
		System.out.printf("%.2f", result);
	}

	// Union: 두 집합을 하나로 합침
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}

	// Find: 루트 찾기 + 경로 압축
	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]); // 경로 압축
		}
		return parent[x];
	}
}