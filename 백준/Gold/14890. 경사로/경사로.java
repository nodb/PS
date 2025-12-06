import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n][n];
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		// x 확인
		line: for (int y = 0; y < n; y++) {
			// 오른쪽으로
			boolean use[] = new boolean[n]; // 경사로 사용 여부 확인
			int prevNum = arr[y][0];
			int prevCnt = 1;
			boolean canRight = true;
			for (int x = 1; x < n; x++) {
				int nowNum = arr[y][x];
				// 같은 칸이면
				if (prevNum == nowNum) {
					prevCnt++;
				}
				// 다른 칸이면
				else {
					// 오른쪽이 높고, 차이가 1
					if (nowNum - prevNum == 1) {
						// 경사크기 가능
						if (prevCnt >= l) {
							// 경사로 사용
							for (int i = x - l; i < x; i++)
								use[i] = true;
							prevNum = nowNum;
							prevCnt = 1;
						}
						// 경사크기 불가능
						else {
							canRight = false;
						}
					}
					// 왼쪽이 높고, 차이가 1
					else if (prevNum - nowNum == 1) {
						prevNum = nowNum;
						prevCnt = 1;
					}
					// 차이가 1보다 큼
					else {
						canRight = false;
					}
				}
				// 하나라도 불가능하면 해당 줄 불가능;
				if (!canRight) {
					continue line;
				}
			}
			// 왼쪽으로
			prevNum = arr[y][n - 1];
			prevCnt = 1;
			boolean canLeft = true;
			for (int x = n - 1; x >= 0; x--) {
				int nowNum = arr[y][x];
				// 같은 칸이면
				if (prevNum == nowNum) {
					prevCnt++;
				}
				// 다른 칸이면
				else {
					// 왼쪽이 높고, 차이가 1
					if (nowNum - prevNum == 1) {
						// 경사크기 가능
						if (prevCnt >= l) {
							// 경사로 사용 여부 확인
							boolean canUse = true;
							if (x + l >= n)
								canUse = false;
							else
								for (int i = x + 1; i <= x + l; i++)
									if (use[i])
										canUse = false;
							if (canUse) {
								prevNum = nowNum;
								prevCnt = 1;
							}
							// 이미 사용한 경사
							else {
								canLeft = false;
							}
						}
						// 경사크기 불가능
						else {
							canLeft = false;
						}
					}
					// 오른쪽이 높고, 차이가 1
					else if (prevNum - nowNum == 1) {
						prevNum = nowNum;
						prevCnt = 1;
					}
					// 차이가 1보다 큼
					else {
						canLeft = false;
					}
				}
				// 하나라도 불가능하면 해당 줄 불가능;
				if (!canLeft) {
					continue line;
				}
			}
			// 오른쪽, 왼쪽 모두 통과해야 +1
			cnt++;
		}
		// y 확인
		line: for (int x = 0; x < n; x++) {
			// 아래쪽으로
			boolean use[] = new boolean[n]; // 경사로 사용 여부 확인
			int prevNum = arr[0][x];
			int prevCnt = 1;
			boolean canDown = true;
			for (int y = 1; y < n; y++) {
				int nowNum = arr[y][x];
				// 같은 칸이면
				if (prevNum == nowNum) {
					prevCnt++;
				}
				// 다른 칸이면
				else {
					// 아래쪽이 높고, 차이가 1
					if (nowNum - prevNum == 1) {
						// 경사크기 가능
						if (prevCnt >= l) {
							// 경사로 사용
							for (int i = y - l; i < y; i++)
								use[i] = true;
							prevNum = nowNum;
							prevCnt = 1;
						}
						// 경사크기 불가능
						else {
							canDown = false;
						}
					}
					// 위쪽이 높고, 차이가 1
					else if (prevNum - nowNum == 1) {
						prevNum = nowNum;
						prevCnt = 1;
					}
					// 차이가 1보다 큼
					else {
						canDown = false;
					}
				}
				// 하나라도 불가능하면 해당 줄 불가능;
				if (!canDown) {
					continue line;
				}
			}
			// 위쪽으로
			prevNum = arr[n - 1][x];
			prevCnt = 1;
			boolean canUp = true;
			for (int y = n - 1; y >= 0; y--) {
				int nowNum = arr[y][x];
				// 같은 칸이면
				if (prevNum == nowNum) {
					prevCnt++;
				}
				// 다른 칸이면
				else {
					// 위쪽이 높고, 차이가 1
					if (nowNum - prevNum == 1) {
						// 경사크기 가능
						if (prevCnt >= l) {
							// 경사로 사용 여부 확인
							boolean canUse = true;
							if (y + l >= n)
								canUse = false;
							else
								for (int i = y + 1; i <= y + l; i++)
									if (use[i])
										canUse = false;
							if (canUse) {
								prevNum = nowNum;
								prevCnt = 1;
							}
							// 이미 사용한 경사
							else {
								canUp = false;
							}
						}
						// 경사크기 불가능
						else {
							canUp = false;
						}
					}
					// 아래쪽이 높고, 차이가 1
					else if (prevNum - nowNum == 1) {
						prevNum = nowNum;
						prevCnt = 1;
					}
					// 차이가 1보다 큼
					else {
						canUp = false;
					}
				}
				// 하나라도 불가능하면 해당 줄 불가능;
				if (!canUp) {
					continue line;
				}
			}
			// 아래쪽, 위쪽 모두 통과해야 +1
			cnt++;
		}
		System.out.println(cnt);
	}
}
