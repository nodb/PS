import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int y, x, n;
    static char[][] arr, full, first, second;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new char[y][x];
        full = new char[y][x]; // 모든 배열 폭탄 O
        first = new char[y][x]; // 첫 번째 폭발
        second = new char[y][x]; // 두 번째 폭발

        // 입력 및 초기화
        for (int i = 0; i < y; i++) {
            String s = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = s.charAt(j);
                full[i][j] = 'O';
                first[i][j] = 'O';
            }
        }

        // 1초 후 : 변화 X
        if (n == 1) {
            print(arr);
            return;
        }

        // 2초 후(짝수) : 항상 모든 칸이 'O'
        if (n % 2 == 0) {
            print(full);
            return;
        }

        // 3초 후
        explode(arr, first);
        // 5초 후
        explode(first, second);

        if (n % 4 == 3) { // 3초 후 패턴
            print(first);
        } else { // 5초 후 패턴
            print(second);
        }
    }

    // 폭발 처리
    static void explode(char[][] before, char[][] after) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                after[i][j] = 'O'; // 모든 칸 폭탄
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (before[i][j] == 'O') {
                    after[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dy[d];
                        int nj = j + dx[d];
                        if (ni >= 0 && ni < y && nj >= 0 && nj < x) {
                            after[ni][nj] = '.';
                        }
                    }
                }
            }
        }
    }

    // 출력 함수
    static void print(char[][] board) {
        for (int i = 0; i < y; i++) {
            sb.append(board[i]).append("\n");
        }
        System.out.print(sb);
    }
}
