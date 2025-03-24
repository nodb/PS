import java.io.*;
import java.util.*;

public class Main {

    // 보드의 크기
    static int N;
    // 보드 정보를 저장하는 2차원 문자 배열
    static char[][] board;
    // 방문 여부를 체크하기 위한 3차원 배열: visited[x][y][dir]
    // dir: 0은 가로, 1은 세로 방향
    static boolean[][][] visited;
    // 상하좌우 이동을 위한 dx, dy 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 상태를 나타내기 위한 클래스 (중심 좌표, 방향, 이동 횟수)
    static class State {
        int x;      // 통나무 중심의 x좌표 (행)
        int y;      // 통나무 중심의 y좌표 (열)
        int dir;    // 통나무의 방향 (0: 가로, 1: 세로)
        int count;  // 현재까지 이동한 횟수

        public State(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        // 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        // 'B' (시작 통나무 위치)와 'E' (목표 위치)를 저장할 리스트
        ArrayList<int[]> bList = new ArrayList<>();
        ArrayList<int[]> eList = new ArrayList<>();

        // 보드 정보를 입력받으며, 'B'와 'E'의 위치를 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'B') {
                    // 통나무 시작 위치 (세 칸 모두) 저장
                    bList.add(new int[]{i, j});
                }
                if (board[i][j] == 'E') {
                    // 목표 위치 (세 칸 모두) 저장
                    eList.add(new int[]{i, j});
                }
            }
        }

        // 시작 상태 결정
        // 통나무는 세 칸이 연속으로 배치되어 있으므로 가운데 좌표가 중심이 됨
        int b_x = bList.get(1)[0];  // 중심의 행
        int b_y = bList.get(1)[1];  // 중심의 열
        int b_dir;                  // 시작 통나무의 방향 (가로:0, 세로:1)
        // 좌표들을 비교하여 가로면 같은 행, 세로면 같은 열임
        if (bList.get(0)[0] == bList.get(1)[0]) {
            b_dir = 0;  // 가로 방향
        } else {
            b_dir = 1;  // 세로 방향
        }

        // 목표 상태 결정 (E의 가운데 좌표와 방향)
        int e_x = eList.get(1)[0];
        int e_y = eList.get(1)[1];
        int e_dir;
        if (eList.get(0)[0] == eList.get(1)[0]) {
            e_dir = 0;
        } else {
            e_dir = 1;
        }

        // 방문 배열 초기화 (N x N x 2)
        visited = new boolean[N][N][2];

        // BFS를 통해 최소 이동 횟수를 계산
        int result = bfs(b_x, b_y, b_dir, e_x, e_y, e_dir);
        System.out.println(result);
    }

    // BFS 메서드: 시작 상태 (sx, sy, sdir)에서 목표 상태 (ex, ey, edir)까지의 최소 이동 횟수를 반환
    static int bfs(int sx, int sy, int sdir, int ex, int ey, int edir) {
        Queue<State> queue = new LinkedList<>();
        // 시작 상태 큐에 추가 및 방문 체크
        queue.add(new State(sx, sy, sdir, 0));
        visited[sx][sy][sdir] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            // 현재 상태가 목표 상태와 일치하면 현재까지의 이동 횟수를 반환
            if (cur.x == ex && cur.y == ey && cur.dir == edir) {
                return cur.count;
            }

            // 4가지 방향(상, 하, 좌, 우)으로 이동 시도
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                // 현재 상태의 방향(cur.dir)과 이동 방향 d를 고려하여 이동이 가능한지 확인
                if (canMove(nx, ny, cur.dir)) {
                    // 아직 방문하지 않은 상태라면 큐에 추가 후 방문 처리
                    if (!visited[nx][ny][cur.dir]) {
                        visited[nx][ny][cur.dir] = true;
                        queue.add(new State(nx, ny, cur.dir, cur.count + 1));
                    }
                }
            }

            // 회전 연산 시도 (회전은 현재 위치를 중심으로 3x3 범위가 모두 비어있어야 함)
            if (canRotate(cur.x, cur.y)) {
                // 방향 전환: 가로(0) → 세로(1) 또는 세로(1) → 가로(0)
                int ndir = (cur.dir == 0) ? 1 : 0;
                if (!visited[cur.x][cur.y][ndir]) {
                    visited[cur.x][cur.y][ndir] = true;
                    queue.add(new State(cur.x, cur.y, ndir, cur.count + 1));
                }
            }
        }
        // 목표 상태로 이동할 수 없는 경우 0을 반환
        return 0;
    }

    // 이동 가능 여부를 확인하는 메서드
    // 매개변수: 새로운 중심 좌표 (x, y)와 현재 통나무 방향 (dir)
    // 통나무의 이동 후 차지하는 모든 칸이 범위 내에 있고 장애물('1')이 없어야 함
    static boolean canMove(int x, int y, int dir) {
        // 새로운 중심 좌표가 보드 범위를 벗어나면 이동 불가
        if (x < 0 || x >= N || y < 0 || y >= N) return false;

        // 통나무가 가로 방향인 경우 (중심 좌표 기준 왼쪽, 중심, 오른쪽 칸)
        if (dir == 0) {
            // y-1부터 y+1까지 반복하며 각 칸이 범위 내 있고 장애물이 없는지 확인
            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0 || j >= N) return false;
                if (board[x][j] == '1') return false;
            }
        } 
        // 통나무가 세로 방향인 경우 (중심 좌표 기준 위, 중심, 아래 칸)
        else {
            for (int i = x - 1; i <= x + 1; i++) {
                if (i < 0 || i >= N) return false;
                if (board[i][y] == '1') return false;
            }
        }
        return true;
    }

    // 회전 가능 여부를 확인하는 메서드
    // 회전하려면 중심을 둘러싼 3x3 영역 내의 모든 칸이 범위 내에 있고 장애물('1')이 없어야 함
    static boolean canRotate(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N) return false;
                if (board[i][j] == '1') return false;
            }
        }
        return true;
    }
}
