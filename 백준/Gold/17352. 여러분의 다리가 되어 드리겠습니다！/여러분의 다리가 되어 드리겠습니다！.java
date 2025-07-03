import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 트리 생성 - Union Find
		parent = new int[n + 1];

		// 부모 초기화
		for (int i = 1; i <= n; i++)
			parent[i] = i;

		for (int i = 0; i < n - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		// 루트가 서로 다른 두 섬 찾기
		int root1 = find(1);
		for (int i = 2; i <= n; i++) {
			int root2 = find(i);
			if (root1 != root2) {
				System.out.println(1 + " " + i);
				break;
			}
		}
	}

	// union
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}

	// find - 경로 압축
	static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
	}
}
