import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[102][102];

        // 색종이 영역을 1로 채우기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int xx = x; xx < x + 10; xx++) {
                for (int yy = y; yy < y + 10; yy++) {
                    arr[yy][xx] = 1;
                }
            }
        }

        // 높이 배열을 만들기 (누적된 세로 높이 계산)
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = arr[i - 1][j] + 1;
                }
            }
        }

        int maxArea = 0;

        // 각 행을 히스토그램으로 변환하여 최대 직사각형 찾기
        for (int y = 1; y <= 100; y++) {
            Stack<Integer> stack = new Stack<>();
            int[] height = new int[102];  // 오른쪽 끝에서 0을 만나게 하기 위해 배열 크기 증가
            for (int x = 1; x <= 101; x++) {
                height[x] = arr[y][x]; // 현재 행을 히스토그램 높이로 변환

                while (!stack.isEmpty() && height[stack.peek()] > height[x]) {
                    int h = height[stack.pop()];
                    int w = stack.isEmpty() ? x - 1 : x - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(x);
            }
        }

        System.out.println(maxArea);
    }
}
