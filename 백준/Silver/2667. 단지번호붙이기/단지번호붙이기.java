import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char arr[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			arr[i] = s.toCharArray();
		}

		ArrayList<Integer> list = new ArrayList<>(); // 단지 저장
		
		boolean visited[][] = new boolean[n][n];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				// 0이면 넘기기
				if (arr[y][x] == '0')
					continue;
				// 이미 방문한 곳이면 넘기기
				if (visited[y][x])
					continue;

				// BFS
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] { x, y });
				visited[y][x] = true;
				int cnt = 0; // 같은 단기 안의 개수
				cnt++;
				while (!q.isEmpty()) {
					int now[] = q.remove();
					int xx = now[0];
					int yy = now[1];
					for (int d = 0; d < 4; d++) {
						int nx = xx + dx[d];
						int ny = yy + dy[d];
						// 범위 넘어가면 넘기기
						if (nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						// 0이면 넘기기
						if (arr[ny][nx] == '0')
							continue;
						// 이미 방문한 곳이면 넘기기
						if (visited[ny][nx])
							continue;
						visited[ny][nx] = true; // 방문 처리
						cnt++; // 개수 추가
						q.add(new int[] { nx, ny }); // Queue 추가
					}
				}
				list.add(cnt);
			}
		}
		Collections.sort(list); // 단지 오름차순 정렬
		StringBuilder sb = new StringBuilder();
		sb.append(list.size() + "\n");
		for (int i : list) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
