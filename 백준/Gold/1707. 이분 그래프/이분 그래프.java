import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		while (k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 정점 개수
			int e = Integer.parseInt(st.nextToken()); // 간선 개수
			ArrayList<Integer> list[] = new ArrayList[v + 1];
			for (int i = 0; i <= v; i++) {
				list[i] = new ArrayList<>();
			}
			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			boolean flag = true;
			int visited[] = new int[v + 1];
			Queue<int[]> q = new LinkedList<>();
			loop:
			for (int i = 1; i <= v; i++) { // 서로 다른 그래프가 여러 개 있는 경우
				if (visited[i] == 0) {
					q.add(new int[] { i, 1 }); // 0 : 숫자, 1 : 위치(1 or 2 토글)
					visited[i] = 1;
					while (!q.isEmpty()) {
						int now[] = q.remove();
						int num = now[0];
						int loc = now[1];
						for (int n : list[num]) {
							int locN = visited[n]; // n의 위치
							// 방문한 적 없다면
							if (locN == 0) {
								int locNext = loc == 1 ? 2 : 1; // 1, 2 토글
								visited[n] = locNext; // visited 업데이트
								q.add(new int[] { n, locNext }); // queue 추가
							}
							// 방문한 적 있고, 들어있는 값 위치 == 현재 값 위치 -> 종료
							else if (locN == loc) {
								flag = false;
								sb.append("NO\n");
								break loop;
							}
							// 방문한 적 있고, 들어있는 값 위치 != 현재 값 위치 -> 넘기기
						}
					}
				}
			}
			if (flag)
				sb.append("YES\n");
		}
		System.out.println(sb);
	}
}