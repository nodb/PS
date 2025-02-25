import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static boolean visited[];
	static int result[];
	static int min_distance;
	static int dis[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			int arr[][] = new int[n + 2][2];

			for (int i = 0; i < n + 2; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			dis = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					dis[i][j] = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
					dis[j][i] = dis[i][j];
				}
			}

			visited = new boolean[n + 2];
			result = new int[n];
			min_distance = Integer.MAX_VALUE;
			perm(2);
			for (int i = 0; i < arr.length; i++) {

			}
			sb.append("#" + tc + " " + min_distance + "\n");
		}
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == n + 2) {
			int sum = dis[0][result[0]] + dis[1][result[n - 1]];
			for (int i = 0; i < n - 1; i++) {
				sum += dis[result[i]][result[i + 1]];
			}
			if (min_distance > sum)
				min_distance = sum;
			return;
		}
		for (int i = 2; i < n + 2; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			result[cnt - 2] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}
