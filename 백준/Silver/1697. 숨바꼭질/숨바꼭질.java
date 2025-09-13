import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 시작 위치
		int K = Integer.parseInt(st.nextToken()); // 목표 위치

		// 시작 위치가 목표 위치라면
		// - 0 출력 후 종료
		if (N == K) {
			System.out.println(0);
			return;
		}

		// 방문 여부 확인(중복 방문 X)
		boolean visited[] = new boolean[MAX + 1];

		// 큐에 {시간, 위치} 형태로 저장
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, N }); // 시작: 시간 0, 위치 N
		visited[N] = true; // 시작 위치 방문 처리

		while (!q.isEmpty()) {
			int now[] = q.remove();
			int time = now[0]; // 현재 시간
			int x = now[1]; // 현재 위치

			// 이동 가능한 3가지 경우
			int next[] = { x - 1, x + 1, x * 2 };

			for (int d : next) {
				if (d < 0 || d > MAX) // 범위 제한
					continue;
				if (visited[d]) // 방문 여부
					continue;
				if (d == K) { // 목표 위치를 찾으면 시간 출력 후 종료
					System.out.println(time + 1);
					return;
				}

				// 방문 처리 후 큐에 넣기
				visited[d] = true;
				q.offer(new int[] { time + 1, d });
			}
		}
	}
}
