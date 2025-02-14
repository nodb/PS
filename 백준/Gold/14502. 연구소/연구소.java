import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int N, M, count_zero_max = 0;
	static int arr[][];
	static int arr_copy[][];
	static List<Pair> location_zero;
	static List<Pair> location_two;
	static List<Integer> selected;
	static boolean combi_visited[];
	static boolean dfs_visited[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		arr_copy = new int[N][M];
		location_zero = new ArrayList<>();
		location_two = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					location_zero.add(new Pair(j, i));
				} else if (arr[i][j] == 2) {
					location_two.add(new Pair(j, i));
				}
			}
		}

		selected = new ArrayList<>();
		combi_visited = new boolean[location_zero.size()];
		combi(0);
		System.out.println(count_zero_max);
	}

	private static void combi(int num) {
		if (selected.size() == 3) {
			// arr_copy로 복사(초기화)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr_copy[i][j] = arr[i][j];
				}
			}
			dfs_visited = new boolean[N][M];
			// 벽 배치
			for (int i : selected) {
				arr_copy[location_zero.get(i).y][location_zero.get(i).x] = 1;
			}
			// dfs 적용
			for (Pair i : location_two) {
				dfs(i);
			}
			// 0 개수 세기
			countZero();
			return;
		}

		for (int i = num; i < location_zero.size(); i++) {
			if (combi_visited[i] == true)
				continue;
			selected.add(i);
			combi_visited[i] = true;
			combi(i + 1);
			combi_visited[i] = false;
			selected.remove(selected.size() - 1);
		}

	}

	private static void dfs(Pair p) {
	    int x = p.x;
	    int y = p.y;
	    dfs_visited[y][x] = true; // 방문 처리

	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];

	        if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; // 범위 초과
	        if (dfs_visited[ny][nx] || arr_copy[ny][nx] != 0) continue; // 이미 방문했거나 벽이 있는 경우

	        arr_copy[ny][nx] = 2; // 바이러스 확산
	        dfs(new Pair(nx, ny)); // 재귀 호출
	    }
	}
	
	private static void countZero() {
		int count_zero = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr_copy[i][j] == 0) {
					count_zero++;
				}
			}
		}
		if (count_zero > count_zero_max) {
			count_zero_max = count_zero;
		}
	}
}

// 최대 64칸
// 벽(1)을 놓을 수 있는 경우 64C3
// 각 경우마다 dfs후 전체에서 0의 개수 count
// count가 max_count보다 큰 경우 갱신