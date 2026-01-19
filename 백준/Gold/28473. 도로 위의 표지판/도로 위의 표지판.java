import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static ArrayList<Pair> list;
	static int parent[]; // 유니온파인드
	static int pickedNum[]; // 선택된 표지판 num
	static int pickedCnt; // 현재 선택된 간선 수
	static long sumCost; // 선택된 cost 합

	static class Pair implements Comparable<Pair> {
		int a;
		int b;
		int num;
		int cost;

		Pair(int a, int b, int num, int cost) {
			this.a = a;
			this.b = b;
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.num == o.num)
				return this.cost - o.cost;
			return this.num - o.num;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 마을
		m = Integer.parseInt(st.nextToken()); // 도로
		list = new ArrayList<>();

		// 도로 정보
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Pair(a, b, num, cost));
		}

		// num 오름차순 -> num 같으면 cost 오름차순
		Collections.sort(list);

		// 크루스칼
		// 유니온파인드로 사이클 판정 + N-1개 간선 선택
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parent[i] = i;

		pickedNum = new int[n - 1]; // 선택된 표지판 num
		pickedCnt = 0; // 현재 선택된 간선 수
		sumCost = 0; // 선택된 cost 합

		for (int i = 0; i < m && pickedCnt < n - 1; i++) {
			Pair p = list.get(i);
			// 사이클이 아니면
			if (union(p.a, p.b)) {
				pickedNum[pickedCnt++] = p.num;
				sumCost += p.cost;
			}
		}

		// 스패닝 트리 만들기 실패(연결 불가)
		if (pickedCnt != n - 1) {
			System.out.println(-1);
			return;
		}

		// 선택된 num들을 오름차순으로 이어붙이면 최소 수
		Arrays.sort(pickedNum);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; i++)
			sb.append(pickedNum[i]);
		sb.append(' ').append(sumCost);
		System.out.println(sb);
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) // 사이클이면
			return false;
		parent[rootB] = rootA;
		return true;
	}

	static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
	}
}
