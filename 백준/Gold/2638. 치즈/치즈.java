import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int arr[][];
    static int visited[][];
    static int arrCopy[][];
    static int cnt = 0;
    static int time = 0;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        arrCopy = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 깊은 복사
        for (int i = 0; i < N; i++) {
            arrCopy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }

        find();

        System.out.println(time);
    }

    private static void find() {

        time++;
        cnt = 0;
        visited = new int[N][M];
        dfs(0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrCopy[i][j] == 3) {
                    arrCopy[i][j] = 0;
                }
                if (arrCopy[i][j] == 2) {
                    arrCopy[i][j] = 1;
                }
            }
        }

        // 깊은 복사
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.copyOf(arrCopy[i], arrCopy[i].length);
        }

        // 1 갯수 구하기
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }
        }

        if (cnt > 0) {
            find();
        }
    }

    private static void dfs(int x, int y) {
        if (arr[y][x] == 1) {
            arrCopy[y][x]++;
            visited[y][x] = 0;
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && visited[ny][nx] == 0) {
                visited[ny][nx] = 1;
                dfs(nx, ny);
            }
        }
    }
}
