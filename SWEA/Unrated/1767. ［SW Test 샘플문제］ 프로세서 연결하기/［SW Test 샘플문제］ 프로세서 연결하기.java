import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int arr[][]; // 각 칸의 비용
	static List<int[]> core; // 프로세서 위치
	static int core_cnt; // 프로세서 갯수
	static int max_core_cnt; // 최대 프로세서 연결 수
	static int min_wire_len; // 최소 전선 연결 수
	static int dx[] = { -1, 0, 1, 0 }; // 상, 좌, 하, 우
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testcase; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			core = new ArrayList<>();
			core_cnt = 0;
			max_core_cnt = 0;
			min_wire_len = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
					    core.add(new int[]{j, i});
					    core_cnt++;
					}
				}
			}

			dfs(0, 0, 0);
			sb.append("#" + tc + " " + min_wire_len + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int connected_core_cnt, int wire_len) { // 연결 횟수, 연결된 완료된 프로세서 갯수, 전선 길이
		if (cnt == core_cnt) { // 프로세서의 갯수만큼 진행됐다면
			if (max_core_cnt < connected_core_cnt) {
				max_core_cnt = connected_core_cnt;
				min_wire_len = wire_len;
			} else if (max_core_cnt == connected_core_cnt) {
				min_wire_len = Math.min(wire_len, min_wire_len);
			}
			return;
		}

		int c[] = core.get(cnt);
		int x = c[0];
		int y = c[1];

		for (int d = 0; d < 4; d++) {
			if (can_connect(x, y, d)) {
				int new_wire_len = add_wire(x, y, d);
				dfs(cnt + 1, connected_core_cnt + 1, wire_len + new_wire_len);
				remove_wire(x, y, d);
			}
		}
		
		dfs(cnt + 1, connected_core_cnt, wire_len); // 프로세서 연결 안 하고 넘어가는 경우
	}

	private static int add_wire(int x, int y, int d) {
		int new_wire_len = 0;
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			arr[ny][nx] = 2;
			new_wire_len++;
			nx += dx[d];
			ny += dy[d];
		}
		return new_wire_len;
	}

	private static void remove_wire(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			arr[ny][nx] = 0;
			nx += dx[d];
			ny += dy[d];
		}
	}

	private static boolean can_connect(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			if (arr[ny][nx] != 0) {
				return false;
			}
			nx += dx[d];
			ny += dy[d];
		}
		return true;
	}
}
