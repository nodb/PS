import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0; // 청소한 칸 개수
        while (true) {
            // 1. 현재 칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소 완료 표시
                count++;
            }

            // 2. 주변 4칸 중 청소되지 않은 빈 칸 확인
            boolean hasCleanable = false;
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                    hasCleanable = true;
                    break;
                }
            }

            if (hasCleanable) {
                // 3. 반시계 회전 후 이동할 수 있으면 이동
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4; // 반시계 방향 회전
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    if (map[nx][ny] == 0) { // 청소되지 않은 빈 칸이면 이동
                        r = nx;
                        c = ny;
                        break;
                    }
                }
            } else {
                // 4. 후진
                int backX = r - dx[d];
                int backY = c - dy[d];

                if (map[backX][backY] == 1) break; // 후진 불가능하면 종료
                r = backX;
                c = backY;
            }
        }

        System.out.println(count);
    }
}
