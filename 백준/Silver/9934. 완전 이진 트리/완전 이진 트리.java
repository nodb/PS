import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> level[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int size = (1 << k) - 1;
		int arr[] = new int[size]; // 빌딩의 번호
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		level = new ArrayList[k]; // 높이별 빌딩
		for (int i = 0; i < k; i++) {
			level[i] = new ArrayList<>();
		}
		tree(arr, 0);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < level[i].size(); j++) {
				System.out.print(level[i].get(j) + " ");
			}
			System.out.println();
		}
	}

	private static void tree(int[] arr, int lv) {
		int mid = arr.length / 2;
		level[lv].add(arr[mid]);
		if (mid != 0) {
			int front[] = Arrays.copyOfRange(arr, 0, mid);
			int back[] = Arrays.copyOfRange(arr, mid + 1, arr.length);
			tree(front, lv + 1);
			tree(back, lv + 1);
		}
	}
}