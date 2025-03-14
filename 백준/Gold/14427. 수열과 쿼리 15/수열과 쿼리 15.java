import java.io.*;
import java.util.*;

public class Main {
	private static int n, height, update_idx;
	private static int arr[], tree[][];

	public static void main(String[] args) throws IOException {
		// 세그먼트 트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		height = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
		int cnt = 2 << height; // 트리 칸 개수
		tree = new int[2][cnt + 1]; // trees[0][] : 값, trees[1][] : 인덱스

		Arrays.fill(tree[0], Integer.MAX_VALUE);

		init(1, arr.length - 1, 1); // 시작, 끝, tree 인덱스
		int M = Integer.parseInt(br.readLine());
		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {
				update_idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				arr[update_idx] = value; // arr[update_idx] -> value로 변경
				update(1, arr.length - 1, 1);
			} else {
				sb.append(tree[1][1] + "\n");
			}
		}
		System.out.println(sb);
	}

	private static void update(int start, int end, int i) {
		if (start == end) {
			tree[0][i] = arr[start]; // 값
			tree[1][i] = start; // 인덱스
			return;
		}
		int mid = (start + end) / 2;
		if (update_idx <= mid)
			update(start, mid, i * 2); // 왼쪽
		else
			update(mid + 1, end, i * 2 + 1); // 오른쪽
		tree[0][i] = Math.min(tree[0][i * 2], tree[0][i * 2 + 1]); // 값
		tree[1][i] = tree[0][i] == tree[0][i * 2] ? tree[1][i * 2] : tree[1][i * 2 + 1]; // 인덱스
	}

	private static void init(int start, int end, int i) {
		if (start == end) {
			tree[0][i] = arr[start]; // 값
			tree[1][i] = start; // 인덱스
			return;
		}
		int mid = (start + end) / 2;
		init(start, mid, i * 2); // 왼쪽
		init(mid + 1, end, i * 2 + 1); // 오른쪽
		tree[0][i] = Math.min(tree[0][i * 2], tree[0][i * 2 + 1]); // 값
		tree[1][i] = tree[0][i] == tree[0][i * 2] ? tree[1][i * 2] : tree[1][i * 2 + 1]; // 인덱스
	}
}
