import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int sum = 0;
	private static boolean isEnd;
	private static int arr[][];
	private static int visited[][];

	private static int dy[] = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			String temp_word[] = temp.split("");
			for (int j = 0; j < M; j++) {
				if (temp_word[j].equals("x"))
					arr[i][j] = 0;
				else {
					arr[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			isEnd = false;
			pipe(0, i);
		}

		for (int i = 0; i < N; i++) {
			if (visited[i][M - 1] == 1)
				sum++;
		}
		
		System.out.println(sum);
	}

	private static void pipe(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N || visited[y][x] == 1 || arr[y][x] == 0)
			return;
		if (x + 1 == M) {
			visited[y][x] = 1;
			isEnd = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (!isEnd) {
				visited[y][x] = 1;
				pipe(x + 1, y + dy[i]);
			}
		}
	}
}
