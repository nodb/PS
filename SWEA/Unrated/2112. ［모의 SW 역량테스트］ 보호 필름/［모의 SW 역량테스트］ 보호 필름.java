import java.io.*;
import java.util.*;

class Solution {
	static int D, W, K;
	static int[][] film;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testcase; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken()); // 필름의 세로 크기
			W = Integer.parseInt(st.nextToken()); // 필름의 가로 크기
			K = Integer.parseInt(st.nextToken()); // 성능 검사 기준 (연속된 K개)

			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	// 백트래킹을 사용하여 약품을 주입하는 모든 경우 탐색
	static void dfs(int depth, int count) {
		// 현재 최소 변경 횟수를 넘어가면 탐색 종료
		if (count >= min)
			return;

		// 모든 행을 탐색했을 때 성능 검사 통과 여부 확인
		if (depth == D) {
			if (check()) {
				min = Math.min(min, count);
			}
			return;
		}

		// 약품을 주입하지 않는 경우
		dfs(depth + 1, count);

		// 원본 배열 저장
		int[] copy = film[depth].clone();

		// 0로 변경
		Arrays.fill(film[depth], 0);
		dfs(depth + 1, count + 1);

		// 1로 변경
		Arrays.fill(film[depth], 1);
		dfs(depth + 1, count + 1);

		// 원래대로 복구
		film[depth] = copy;
	}

	// 모든 열이 K개 이상의 연속된 같은 숫자를 포함하는지 확인
	private static boolean check() {
		for (int x = 0; x < W; x++) {
			int len = 0;
			for (int y = 0; y < K; y++) {
				len += film[y][x];
			}
			if (len == 0 || len == K)
				continue;
			for (int y = K; y < D; y++) {
				len += film[y][x];
				len -= film[y - K][x];
				if (len == 0 || len == K)
					break;
			}
			if (len == 0 || len == K) {
				continue;
			}
			return false;
		}
		return true;
	}
}
