import java.io.*;

class Main {
	static int n, count = 0;
	static boolean[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new boolean[n][n]; // 체스판 초기화
		dfs(0);
		System.out.println(count);
	}

	private static void dfs(int y) {
		if (y == n) {
			count++;
			return;
		}

		for (int x = 0; x < n; x++) {
			if (isSafe(x, y)) {
				board[y][x] = true; // 퀸 배치
				dfs(y + 1);
				board[y][x] = false; // 백트래킹 (퀸 제거)
			}
		}
	}

	private static boolean isSafe(int x, int y) {
		// 세로(위쪽) 체크
		for (int i = 0; i < y; i++) {
			if (board[i][x])
				return false;
		}

		// 왼쪽 위 대각선 체크
		for (int i = 1; i <= y && x - i >= 0; i++) {
			if (board[y - i][x - i])
				return false;
		}

		// 오른쪽 위 대각선 체크
		for (int i = 1; i <= y && x + i < n; i++) {
			if (board[y - i][x + i])
				return false;
		}

		return true; // 배치 가능
	}
}
