import java.io.*;
import java.util.*;

class Solution {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        int visited[][] = new int[m][n];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // x, y
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            int now[] = q.remove();
            int x = now[0];
            int y = now[1];
            int cnt = visited[y][x];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[ny][nx] == 0 || visited[ny][nx] != 0)
                    continue;
                if (ny == m - 1 && nx == n - 1)
                    return cnt + 1;
                visited[ny][nx] = cnt + 1;
                q.add(new int[]{nx, ny});
            }
        }

        return -1;
    }
}