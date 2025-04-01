import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N, M;
	static int arr[][], visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			int j = 0;
			for (String s : br.readLine().split("")) {
				arr[i][j] = Integer.parseInt(s);
				j++;
			}
		}

		bfs();

		System.out.println(visited[N-1][M-1]);

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited[0][0] = 1;
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[y][x] == 1 && visited[ny][nx] == 0) {
					visited[ny][nx] = visited[y][x] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
