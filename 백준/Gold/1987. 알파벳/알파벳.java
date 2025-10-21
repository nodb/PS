import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int r;
	static int c;
	static char[][] arr;
	static boolean[][] visited;
	static int cnt;
	static int max;
	static Set<Character> s = new HashSet<>(); // 지나온 알파벳

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			arr[i] = s.toCharArray();
		}

		// DFS
		max = 1;
		s.add(arr[0][0]);
		visited = new boolean[r][c];
		dfs(0, 0, 1);

		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= c || ny >= r || visited[ny][nx] || s.contains(arr[ny][nx])) {
				continue;
			}
			visited[ny][nx] = true;
			s.add(arr[ny][nx]);
			max = Math.max(max, cnt + 1);
			dfs(nx, ny, cnt + 1);
			visited[ny][nx] = false;
			s.remove(arr[ny][nx]);
		}
	}
}