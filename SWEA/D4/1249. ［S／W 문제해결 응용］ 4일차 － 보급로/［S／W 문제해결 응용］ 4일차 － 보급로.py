import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static int N;
    static int arr[][]; // 각 칸의 비용
    static int cost[][]; // 최소 비용
    static int dx[] = { -1, 0, 1, 0 }; // 상, 좌, 하, 우
    static int dy[] = { 0, -1, 0, 1 };

    // Cell 클래스: (x, y) 좌표와 그 칸까지의 최소 비용을 담은 클래스
    static class Cell implements Comparable<Cell> {
        int x, y, cost;

        public Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        // PriorityQueue에서 비용을 기준으로 비교
        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testcase; tc++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N][N];
            cost = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE); // 비용 배열 초기화
            }
            for (int i = 0; i < N; i++) {
            	String s = br.readLine();
            	int c = 0;
                for (int j = 0; j < s.length(); j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            int result = bfs();
            sb.append("#" + tc + " " + result + "\n");
		}
        System.out.println(sb);
    }

    // BFS (Dijkstra와 유사)
    private static int bfs() {
        PriorityQueue<Cell> q = new PriorityQueue<>();
        q.offer(new Cell(0, 0, arr[0][0])); // 시작점
        cost[0][0] = arr[0][0]; // 시작점의 비용 초기화

        while (!q.isEmpty()) {
            Cell cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            // 이미 더 작은 비용으로 갱신된 경우
            if (cost[cy][cx] < cur.cost)
                continue;

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 범위 체크
                if (!check(nx, ny))
                    continue;

                // 새로운 경로가 더 작은 비용을 가지면 갱신
                if (cost[ny][nx] > cost[cy][cx] + arr[ny][nx]) {
                    cost[ny][nx] = cost[cy][cx] + arr[ny][nx];
                    q.offer(new Cell(nx, ny, cost[ny][nx]));
                }
            }
        }

        return cost[N-1][N-1]; // 목표지점의 최소 비용 반환
    }

    // 범위 체크
    private static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
