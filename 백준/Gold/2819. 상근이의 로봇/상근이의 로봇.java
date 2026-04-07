import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 좌표별 점 개수 저장
		int[] xCntArr = new int[1_000_000 * 2 + 1];
		int[] yCntArr = new int[1_000_000 * 2 + 1];

		int xLeftCnt = 0; // 현재 x보다 작은 점 개수
		int xZeroCnt = 0; // 현재 x와 같은 점 개수
		int xRightCnt = 0; // 현재 x보다 큰 점 개수

		int yLeftCnt = 0; // 현재 y보다 작은 점 개수
		int yZeroCnt = 0; // 현재 y와 같은 점 개수
		int yRightCnt = 0; // 현재 y보다 큰 점 개수

		long answer = 0; // 거리 합은 int 범위를 넘을 수 있으니 long

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());

			xCntArr[px + 1_000_000]++;
			yCntArr[py + 1_000_000]++;

			answer += Math.abs(px) + Math.abs(py);

			// 시작 위치는 (0,0)
			if (px < 0)
				xLeftCnt++;
			else if (px == 0)
				xZeroCnt++;
			else
				xRightCnt++;

			if (py < 0)
				yLeftCnt++;
			else if (py == 0)
				yZeroCnt++;
			else
				yRightCnt++;
		}

		char[] c = br.readLine().toCharArray();

		int x = 0;
		int y = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			if (c[i] == 'S') { // (x, y+1)
				y++;

				// 음수/0은 +1, 양수는 -1
				answer += (long) yLeftCnt + yZeroCnt - yRightCnt;

				// 기준점 이동 후 개수 갱신
				yLeftCnt += yZeroCnt;
				yZeroCnt = yCntArr[y + 1_000_000];
				yRightCnt -= yZeroCnt;
			} else if (c[i] == 'J') { // (x, y-1)
				y--;

				// 양수/0은 +1, 음수는 -1
				answer += (long) yRightCnt + yZeroCnt - yLeftCnt;

				yRightCnt += yZeroCnt;
				yZeroCnt = yCntArr[y + 1_000_000];
				yLeftCnt -= yZeroCnt;
			} else if (c[i] == 'I') { // (x+1, y)
				x++;

				answer += (long) xLeftCnt + xZeroCnt - xRightCnt;

				xLeftCnt += xZeroCnt;
				xZeroCnt = xCntArr[x + 1_000_000];
				xRightCnt -= xZeroCnt;
			} else if (c[i] == 'Z') { // (x-1, y)
				x--;

				answer += (long) xRightCnt + xZeroCnt - xLeftCnt;

				xRightCnt += xZeroCnt;
				xZeroCnt = xCntArr[x + 1_000_000];
				xLeftCnt -= xZeroCnt;
			}
			sb.append(answer).append('\n');
		}

		System.out.print(sb);
	}
}