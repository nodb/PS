import java.io.*;
import java.util.*;

public class Main {
	static int root[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		root = new int[N + 1]; // 사람의 루트
		for (int i = 0; i < N + 1; i++) { // 루트 초기화
			root[i] = i;
		}
		int M = Integer.parseInt(st.nextToken()); // 파티 수
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		if (know == 0) {
			System.out.println(M);
			return;
		}
		
		int firstRoot = -1;
		// 진실을 아는 사람의 모든 요소의 부모를 첫 번째 요소로 할당
		for (int i = 0; i < know; i++) {
			if (i == 0) {
				firstRoot = Integer.parseInt(st.nextToken());
				root[firstRoot] = firstRoot;
				continue;
			}
			root[Integer.parseInt(st.nextToken())] = firstRoot;
		}
		ArrayList<Integer> party[] = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 파티 M개를 돌면서 모든 요소의 부모를 첫 번째의 최종 부모로 다 할당
		for (int i = 0; i < M; i++) {
			int first = party[i].get(0);
			for (int j = 0; j < party[i].size(); j++) {
				union(first, party[i].get(j));
			}
		}
		
		// 파티 M개를 돌면서 모든 요소의 부모가 최종 부모에 하나도 해당하지 않으면 +1
		firstRoot = find(firstRoot);
		int cnt = M;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < party[i].size(); j++) {
				if (find(party[i].get(j)) == firstRoot) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB)
			root[rootB] = rootA;
	}

	private static int find(int i) {
		if (root[i] != i)
			root[i] = find(root[i]);
		return root[i];
	}
}
