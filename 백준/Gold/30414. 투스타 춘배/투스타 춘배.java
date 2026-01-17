import java.io.*;
import java.util.*;

public class Main {
	static int node[];
	static List<Integer> edge[];
	static boolean visited[];
	static int sum[];

	public static void main(String[] args) throws Exception {
		// 트리에서 부족한 흙은 부모로 올려 보내고
		// 남는 흙은 위로 못 가져가니 버린다
		// 단말 정점 -> 시작 정점으로 누적
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 산의 개수 = 정점
		int p = Integer.parseInt(st.nextToken()); // 춘배가 고른 산(부대) = 시작 정점
		// 원래 산의 높이 = 현재 정점 값
		// 춘배가 원하는 산의 높이 = 목표 정점 값
		// node : 현재 - 목표
		node = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			node[i] -= Integer.parseInt(st.nextToken());
		}

		// 산과 산을 잇는 길 = 간선
		edge = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edge[u].add(v);
			edge[v].add(u);
		}

		// DP 문제 -> 단말 정점부터 시작 정점까지 타고 올라가야함
		// 현재 정점 누적합 = 가능한 모든 다음 정점 누적합 다 더하기 + 현재 정점 값(부호 반대로)
		// 현재 정점 누적합 < 0인 경우 -> 0으로 변경
		visited = new boolean[n + 1]; // 방문 여부
		sum = new int[n + 1]; // 누적합
		visited[p] = true;
		dp(p); // 누적합 채우기
		System.out.println(sum[p]);
	}

	static void dp(int n) {
		List<Integer> canNode = new ArrayList<>();
		for (int next : edge[n]) {
			if (!visited[next]) { // 방문한 적 없으면
				canNode.add(next);
				visited[next] = true;
				dp(next);
			}
		}
		// n이 아무곳도 방문하지 않음 -> 단말노드
		if (canNode.isEmpty()) {
			// 정점 값 > 0 -> 무시(0)
			// 정점 값 < 0 -> 해당 값 부호 변경
			if (node[n] < 0)
				sum[n] -= node[n];
		}
		// 단말노드가 아니면 -> 가능한 모든 다음 정점 누적합 다 더하기 + 현재 정점 값(부호 반대로)
		else {
			sum[n] -= node[n]; // 현재 정점 값(부호 반대로)
			// 가능한 모든 다음 정점 누적합 다 더하기
			for (int next : canNode) {
				sum[n] += sum[next];
			}
			// 현재 정점 누적합 < 0 -> 0으로 변경
			if (sum[n] < 0)
				sum[n] = 0;
		}
	}
}
