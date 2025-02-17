import java.util.*;
import java.io.*;

class Main {
    // 상하좌우 이동 방향
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    // 말처럼 이동할 수 있는 8방향
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int W, H, K;
    static int[][] map;
    static boolean[][][] visited;

    static class Monkey {
        int x, y, k, count;

        public Monkey(int x, int y, int k, int count) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }
    }

    public static int bfs() {
        Queue<Monkey> queue = new LinkedList<>();
        queue.offer(new Monkey(0, 0, K, 0));  // 시작점 (0,0), 말 이동 K번 가능, 이동 횟수 0
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            Monkey monkey = queue.poll();
            int x = monkey.x;
            int y = monkey.y;
            int k = monkey.k;
            int count = monkey.count;

            // 도착 지점에 도달하면 최소 이동 횟수 반환
            if (x == H - 1 && y == W - 1) {
                return count;
            }

            // 1. 일반적인 이동 (4방향)
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !visited[nx][ny][k]) {
                    visited[nx][ny][k] = true;
                    queue.offer(new Monkey(nx, ny, k, count + 1));
                }
            }

            // 2. 말처럼 이동 (8방향) - 말 이동 가능 횟수가 남아있을 때만
            if (k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + hx[i];
                    int ny = y + hy[i];

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !visited[nx][ny][k - 1]) {
                        visited[nx][ny][k - 1] = true;
                        queue.offer(new Monkey(nx, ny, k - 1, count + 1));
                    }
                }
            }
        }

        // 도달할 수 없는 경우 -1 반환
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());  // 말처럼 이동할 수 있는 횟수
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 너비 (열 개수)
        H = Integer.parseInt(st.nextToken()); // 높이 (행 개수)

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];  // 방문 여부를 [x][y][말 이동 횟수]로 관리

        // 맵 입력 받기
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS 실행 및 결과 출력
        System.out.println(bfs());
    }
}
