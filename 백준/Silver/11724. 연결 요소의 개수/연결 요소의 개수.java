import java.io.*;
import java.util.*;

public class Main {
	static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수

		// 연결 요소의 개수 -> 각 정점을 간선으로 연결 시키고, 서로 다른 집합의 개수 세기

		// Union-Find 유니온-파인드(Disjoint Set Union)
		// - 배열에 같은 집합(루트) 번호를 저장하여, 동일 집합임을 확인하는 방법

		// parent[i] : i 정점의 루트 번호, 같은 루트 번호는 같은 집합을 의미
		// 처음에는 루트값을 자신의 값으로 초기화
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u, v);
		}

		// 개수 세기
		// 방법 1. 전체 boolean 배열 생성하여 확인 여부 체크 
		int cnt = 0;
		boolean check[] = new boolean[N + 1]; // 여부 확인
		for (int i = 1; i <= N; i++) {
			int root = find(parent[i]);
			if (!check[root]) {
				check[root] = true;
				cnt++;
			}
		}
		System.out.println(cnt);
		
		// 방법 2. HashSet(중복 X)에 넣어서 개수 확인
//		HashSet<Integer> hs = new HashSet<>();
//		for (int i = 1; i <= N; i++) {
//			hs.add(find(parent[i]));
//		}
//		System.out.println(hs.size());
	}

	// 루트값 동일 여부 확인 함수
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) { // 루트 값이 동일하지 않다면
			parent[rootB] = rootA; // 루트 동일하게 바꾸기
		}
	}

	// 루트값 찾기 함수
	static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]); // 경로 압축 기법
		return parent[x];
	}
}
