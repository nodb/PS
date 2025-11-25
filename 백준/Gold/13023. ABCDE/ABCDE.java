import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> list[];
	static boolean visited[];
	static boolean check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(i, 1);
		}
		System.out.println(check ? 1 : 0);
	}

	static void dfs(int num, int cnt) {
		for (int next : list[num]) {
			if (check) {
				return;
			}
			if (visited[next]) {
				continue;
			}
			if (cnt + 1 == 5) {
				check = true;
				return;
			}
			visited[next] = true;
			dfs(next, cnt + 1);
			visited[next] = false;
		}
	}
}