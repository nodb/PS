import java.io.*;
import java.util.*;

public class Main { 
    static int cnt = 0;
    static char arr[][] = new char[12][6];
    static boolean visited[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        boolean flag;
        while (true) {
            flag = false;
            visited = new boolean[12][6];

            // 연쇄 확인 및 터트리기
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.' && !visited[i][j]) {
                        List<int[]> puyos = new ArrayList<>();
                        dfs(j, i, arr[i][j], puyos);

                        if (puyos.size() >= 4) {
                            flag = true;
                            for (int[] p : puyos) {
                                arr[p[1]][p[0]] = '.'; // 터트리기
                            }
                        }
                    }
                }
            }

            if (!flag) break; // 연쇄가 없으면 종료
            cnt++; // 연쇄 발생 횟수 증가

            dropPuyos(); // 블록 내리기
        }

        System.out.println(cnt);
    }

    private static void dfs(int x, int y, char color, List<int[]> puyos) {
        visited[y][x] = true;
        puyos.add(new int[]{x, y});

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= 6 || ny >= 12) continue;
            if (visited[ny][nx] || arr[ny][nx] != color) continue;

            dfs(nx, ny, color, puyos);
        }
    }

    private static void dropPuyos() {
        for (int x = 0; x < 6; x++) {
            Queue<Character> queue = new LinkedList<>();

            // 아래에서부터 블록을 큐에 추가
            for (int y = 11; y >= 0; y--) {
                if (arr[y][x] != '.') {
                    queue.add(arr[y][x]);
                    arr[y][x] = '.';
                }
            }

            // 블록을 아래에서부터 채우기
            int y = 11;
            while (!queue.isEmpty()) {
                arr[y--][x] = queue.poll();
            }
        }
    }
}
