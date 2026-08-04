import java.io.*;
import java.util.*;

class Solution {
    /* arr : 전체 보드 + 해당 칸에 최소 움직임 표현
     * 각 초기값
     * "R"(시작) : 0
     * "G"(목표) : -2
     * "D"(장애물) : -1
     * "."(빈공간) : 10000 <- 나올 수 있는 가장 큰 최소 움직임보다 큰 임의의 값으로 지정
     */
    static int arr[][];
    
    public int solution(String[] board) {
        // arr 배열 크기 초기화
        int y = board.length; // 세로 크기
        int x = board[0].length(); // 가로 크기
        arr = new int[y][x]; // 초기화
        
        // 시작 위치
        int startX = 0;
        int startY = 0;
        
        // arr 입력
        for (int yy = 0; yy < y; yy++) { // y
            for (int xx = 0; xx < x; xx++) { // x
                if (board[yy].charAt(xx) == 'G') {
                    arr[yy][xx] = -2;
                } else if (board[yy].charAt(xx) == 'D') {
                    arr[yy][xx] = -1;
                } else if (board[yy].charAt(xx) == '.') {
                    arr[yy][xx] = 10000;
                } else if (board[yy].charAt(xx) == 'R') { // 시작 위치 저장
                    startX = xx;
                    startY = yy;
                }
            }
        }
        
        // 실제 초기화된 arr 배열 로그
        // for (int yy = 0; yy < y; yy++) { // y
        //     for (int xx = 0; xx < x; xx++) { // x
        //         System.out.print(arr[yy][xx] + " ");
        //     }
        //     System.out.println();
        // }
        
        // 네 방향 변수
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        
        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0}); // X좌표, Y좌표, 최소이동수 (x와 y의 방향 유의)
        
        while(!q.isEmpty()) {
            int now[] = q.remove();
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];
            
            for (int d = 0; d < 4; d++) {
                /* 일반 BFS : 상하좌우 한 칸씩 이동하며 다음 위치 탐색
                 * 라코쳇 로봇 : 한 방향을 선택 -> 벽이나 장애물을 만나기 전까지 계속 이동
                 *
                 * 네 방향의 최종적으로 멈추는 위치를 확인!!
                 *
                 * 이동 과정
                 * 1. 현재 위치에서 선택한 방향으로 한 칸씩 전진
                 * 2. 다음 칸이 범위를 벗어나거나 장애물이면 이동 종료
                 * 3. 마지막으로 이동 가능했던 위치가 실제 도착 위치
                 *
                 * 이동이 끝난 후
                 * - 도착 위치 == 현재 위치 : 그 방향으로는 이동할 수 없으므로 무시
                 * - 도착 위치 == 목표(G) : 최소 이동 횟수이므로 바로 반환
                 * - 처음 방문하거나 더 적은 횟수로 도착한 경우 : 최소 이동 횟수 갱신 후 큐에 추가
                 * - 이미 더 적은 횟수로 방문한 경우 : 탐색하지 않음
                 */
                int nx = nowX;
                int ny = nowY;

                // 해당 방향으로 끝까지 이동
                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];

                    // 범위를 벗어나거나 장애물이면 종료
                    if (tx < 0 || tx >= x || ty < 0 || ty >= y)
                        break;

                    if (arr[ty][tx] == -1)
                        break;

                    nx = tx;
                    ny = ty;
                }

                // 움직이지 못한 경우
                if (nx == nowX && ny == nowY)
                    continue;

                // 목표에 도착
                if (arr[ny][nx] == -2)
                    return nowZ + 1;

                // 더 적은 횟수로 방문 가능한 경우
                if (arr[ny][nx] > nowZ + 1) {
                    arr[ny][nx] = nowZ + 1;
                    q.add(new int[]{nx, ny, nowZ + 1});
                }
            }
        }

        // 목표위치에 도달 불가
        return -1;
    }
}



