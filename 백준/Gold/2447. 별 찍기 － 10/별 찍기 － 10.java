import java.util.Scanner;

public class Main{
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new char[n][n];

        // 보드 초기화: 공백 문자로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ' ';
            }
        }

        star(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void star(int r, int c, int n) {
        if (n == 1) {
            board[r][c] = '*'; // 크기가 1일 때 별을 찍음
        } else {
            int size = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 중앙 3x3 영역은 공백을 남김
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    star(r + i * size, c + j * size, size);
                }
            }
        }
    }
}
