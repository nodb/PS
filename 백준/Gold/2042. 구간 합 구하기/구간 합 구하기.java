import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, a, b, height, cnt;
	static long arr[], tree[];
	static long c, sum;

	public static void main(String[] args) throws Exception {
		// 세그먼트 트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];

		height = (int) Math.floor(Math.log(N) / Math.log(2)) + 1;
		cnt = 2 << height ;
		tree = new long[cnt + 1];

		for (int i = 1; i < N + 1; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1, 1, N);
		

		for (int i = 0; i < M + K; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // 1: arr[b] = c, 2: print(b~c)
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if (a == 1) { // 1: update
				arr[b] = c;
				update(1, 1, N);
			} else { // 2 : print
				print(1, 1, N);
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb);
	}

	// tree 구간합 구하기
	private static void print(int node, int start, int end) {
		if (end < b || start > c) // 현재 구간이 b-c를 벗어남
			return;
		if (start == end || b <= start && end <= c) { // 리프 노드에 도달, 현재 구간이 b-c 사이에 존재
			sum += tree[node];
			return;
		}
		int mid = (start + end) / 2;
		print(node * 2, start, mid); // 왼쪽 자식 노드
		print(node * 2 + 1, mid + 1, end); // 오른쪽 자식 노드
	}

	// tree 업데이트
	private static void update(int node, int start, int end) {
		if (b < start || b > end) // 현재 구간에 b가 없으면 업데이트할 필요 없음
			return;
		if (start == end) { // 리프 노드에 도달
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		update(node * 2, start, mid); // 왼쪽 자식 노드
		update(node * 2 + 1, mid + 1, end); // 오른쪽 자식 노드
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
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
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
