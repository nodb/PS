import java.io.*;
import java.util.*;

public class Main {
	static int n, cnt;
	static int[][] arr;
	static int[][] cost;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	
	static class Cell implements Comparable<Cell> {
		int x, y, cost;

		public Cell(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Cell other) {
			return Integer.compare(this.cost, other.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			arr = new int[n][n];
			cost = new int[n][n]; // cost 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = bfs();
			System.out.println("Problem " + (cnt++) + ": " + result);
		}
	}

	private static int bfs() {
		PriorityQueue<Cell> q = new PriorityQueue<>();
		q.offer(new Cell(0, 0, arr[0][0])); // 시작점
		cost[0][0] = arr[0][0]; // 시작점 초기화
		
		while (!q.isEmpty()) {
			Cell cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (cost[ny][nx] > cost[cy][cx] + arr[ny][nx]) {
					cost[ny][nx] = cost[cy][cx] + arr[ny][nx];
					q.offer(new Cell(nx, ny, cost[ny][nx]));
				}
			}
		}
		return cost[n-1][n-1]; // 목표지점의 최소 비용 반환
	}
}