import java.io.*;
import java.util.*;

public class Main {
	static int N, M, height, cnt;
	static int arr[], tree[];
	static int a, b, min;

	public static void main(String[] args) throws Exception {
		// 세그먼트 트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		height = (int) Math.ceil(Math.log(N) / Math.log(2));
		cnt = 2 << height;
		tree = new int[cnt];

		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(1, 1, N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // a-b 중 최소값 
			b = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			print(1, 1, N);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	// tree 구간합 구하기
	private static void print(int node, int start, int end) {
		if (end < a || start > b) // 현재 구간이 b-c를 벗어남
			return;
		if (start == end || a <= start && end <= b) { // 리프 노드에 도달, 현재 구간이 b-c 사이에 존재
			min = Math.min(min, tree[node]);
			return;
		}
		int mid = (start + end) / 2;
		print(node * 2, start, mid); // 왼쪽 자식 노드
		print(node * 2 + 1, mid + 1, end); // 오른쪽 자식 노드
	}

	// tree 초기화
	private static void init(int node, int start, int end) {
		if (start == end) { // 리프 노드에 도달
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(node * 2, start, mid); // 왼쪽 자식 노드
		init(node * 2 + 1, mid + 1, end); // 오른쪽 자식 노드
		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}
}
