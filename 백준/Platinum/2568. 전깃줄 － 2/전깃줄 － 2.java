import java.io.*;
import java.util.*;

public class Main {
	public static class Pair implements Comparable<Pair> {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pair(x, y));
		}
		Collections.sort(list);

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = list.get(i).y;

		int dp[] = new int[n]; // dp: 현재 길이에 대응하는 최솟값(y)
		int index[] = new int[n]; // index: dp의 각 위치에 해당하는 원래 arr의 인덱스
		int parent[] = new int[n]; // parent: 각 원소가 LIS에서 바로 이전에 오는 원소의 인덱스
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);

		int length = 0;
		for (int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(dp, arr[i]);
			if (pos < 0)
				pos = -(pos + 1);
			dp[pos] = arr[i];
			index[pos] = i;
			if (pos > 0)
				parent[i] = index[pos - 1];
			if (pos == length)
				length++;
		}

		int includeList[] = new int[length];
		int k = index[length - 1];
		for (int i = length - 1; i >= 0; i--) {
			includeList[i] = k;
			k = parent[k];
		}

		// LIS에 포함된 전깃줄은 false로 변경
		boolean check[] = new boolean[n];
		Arrays.fill(check, true);
		for (int i : includeList)
			check[i] = false;

		// 제거할 전깃줄의 개수는 전체 개수 - LIS의 길이
		int removedCount = n - length;
		System.out.println(removedCount);
		for (int i = 0; i < n; i++)
			if (check[i])
				System.out.println(list.get(i).x);
	}
}
