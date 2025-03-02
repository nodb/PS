import java.io.*;
import java.util.*;

public class Main {
	static int n, move = 0, size = 2, eat = 0;
	static int shark[];
	static int arr[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static class Pair implements Comparable<Pair> {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// 우선순위 큐에서 y 작은 순 -> x 작은 순
		@Override
		public int compareTo(Pair p) {
			if (this.y == p.y) {
				return Integer.compare(this.x, p.x);
			}
			return Integer.compare(this.y, p.y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		shark = new int[2];

		for (int y = 0; y < n; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 9) {
					shark[0] = x;
					shark[1] = y;
					arr[y][x] = 0;
				}
			}
		}

		while (true) {
			int prev_move = move;
			bfs();
			if (prev_move == move) // 이동 안 했으면 종료
				break;
		}

		System.out.println(move);

	}

	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(shark[0], shark[1]));
		visited = new boolean[n][n];
		visited[shark[1]][shark[0]] = true;

		int temp_dis = 0; // 가장 가까운 물고기 거리
		Queue<Pair> temp_loc = new PriorityQueue<>(); // 먹이 후보

		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Pair now = q.poll();
				int x = now.x;
				int y = now.y;

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n) // 경계 확인
						continue;
					if (visited[ny][nx]) // 이미 방문한 곳이면 스킵
						continue;
					if (arr[ny][nx] > size) // 상어보다 큰 물고기가 있는 곳이면 이동 불가능
						continue;

					visited[ny][nx] = true;
					q.offer(new Pair(nx, ny));

					if (arr[ny][nx] != 0 && arr[ny][nx] < size) { // 먹이 후보 추가
						temp_loc.add(new Pair(nx, ny));
					}
				}
			}

			temp_dis++;
			if (!temp_loc.isEmpty()) // 먹이 후보 있다면
				break;
		}

		if (temp_loc.isEmpty()) // 먹을 물고기가 없다면 종료
			return;

		Pair fish = temp_loc.poll(); // 가장 우선순위가 높은 물고기
		shark[0] = fish.x;
		shark[1] = fish.y;
		arr[shark[1]][shark[0]] = 0; // 먹은 물고기 위치 초기화
		move += temp_dis; // 이동 거리 증가
		eat++; // 먹은 물고기 개수 증가

		// 상어 크기 증가
		if (eat == size) {
			size++;
			eat = 0;
		}
	}
}