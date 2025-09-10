import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { -1, 1, 0, 0, 0, 0 };
	static int dy[] = { 0, 0, -1, 1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // 층
			if (L == 0) {
				System.out.println(sb);
				return;
			}
			int R = Integer.parseInt(st.nextToken()); // 행
			int C = Integer.parseInt(st.nextToken()); // 열

			char arr[][][] = new char[L][R][C];

			int startX = -1;
			int startY = -1;
			int startZ = -1;
			int endX = -1;
			int endY = -1;
			int endZ = -1;

			for (int z = 0; z < L; z++) {
				for (int y = 0; y < R; y++) {
					arr[z][y] = br.readLine().toCharArray();
					if (startX == -1) {
						for (int x = 0; x < C; x++) {
							if (arr[z][y][x] == 'S') {
								startX = x;
								startY = y;
								startZ = z;
							}
						}
					}
					if (endX == -1) {
						for (int x = 0; x < C; x++) {
							if (arr[z][y][x] == 'E') {
								endX = x;
								endY = y;
								endZ = z;
							}
						}
					}
				}
				br.readLine();
			}

			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { startX, startY, startZ, 0 });
			boolean visited[][][] = new boolean[L][R][C];
			visited[startZ][startY][startX] = true;
			int cnt = 0;
			loop: while (!q.isEmpty()) {
				int now[] = q.remove();
				int x = now[0];
				int y = now[1];
				int z = now[2];
				int c = now[3];
//			System.out.println(x + " " + y + " " + z + " " + c);
				for (int d = 0; d < 6; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					int nz = z + dz[d];
					if (nx < 0 || ny < 0 || nz < 0 || nx >= C || ny >= R || nz >= L)
						continue;
					if (visited[nz][ny][nx])
						continue;
					if (arr[nz][ny][nx] == '#')
						continue;
					if (arr[nz][ny][nx] == 'E') {
						cnt = c + 1;
						break loop;
					}
					visited[nz][ny][nx] = true;
					q.add(new int[] { nx, ny, nz, c + 1 });
				}
			}
			if (cnt == 0)
				sb.append("Trapped!").append('\n');
			else
				sb.append("Escaped in " + cnt + " minute(s).").append('\n');
		}
	}
}