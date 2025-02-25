import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] dist;
	static int[][] dp;
	static int min;
	static int INF = Integer.MAX_VALUE / 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[1 << N][N];
		/* 
		 * dp[visited][city]
		 * 가능한 모든 방문 상태(부분 문제)를 저장하는 역할
		 * visited: 현재까지 방문한 도시를 비트마스킹으로 표현
		 * 			1 << N -> 2^N 크기 배열 생성
		 * 			0001 (1) → 0번 도시만 방문
		 *			1011 (11) → 0, 1, 3번 도시 방문
		 *			1111 (15) → 모든 도시 방문
		 * city: 현재 위치한 도시
		 */
		for (int i = 0; i < 1 << N; i++) {
			Arrays.fill(dp[i], -1);
		}
		min = tsp(1, 0);
		System.out.println(min);

	}

	private static int tsp(int visited, int city) {
		// 모든 도시를 방문했는지 확인
		if (visited == ((1 << N) - 1)) { // 예: 1111 = 15
			// 만약 연결이 안되어 있다면
			if (dist[city][0] == 0)
				return INF;
			return dist[city][0]; // 마지막 도시와 집까지 거리
								  // 출발점(0번 도시)으로 돌아가는 거리 반환
		}

		// 이미 방문한 경우 DP값 반환 (메모이제이션)
		if (dp[visited][city] != -1) {
			return dp[visited][city];
		}

		dp[visited][city] = INF;
		
		// 모든 가능한 다음 도시 탐색
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0) // 이미 방문한 도시면 건너뛰기
				continue;
			if (dist[city][i] == 0) // 도시간 거리가 0이면 연결이 안된 상태이므로 건너뛰기
				continue;

			// 다음 도시 방문 및 최소 비용 갱신
			int res = tsp(visited | (1 << i), i) + dist[city][i];
			// visited | (1 << i): 새로운 도시 i 방문 표시
			// res: 재귀 호출을 통해 나머지 도시를 방문하는 비용 + 현재 도시에서 i번 도시로 가는 거리
			// dp[visited][city]를 최소값으로 갱신
			dp[visited][city] = Math.min(res, dp[visited][city]);
		}
		return dp[visited][city];
	}
}