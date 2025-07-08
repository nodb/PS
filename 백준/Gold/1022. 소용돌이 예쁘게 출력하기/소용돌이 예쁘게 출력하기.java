import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());

		// 반지름 r이 주어질 때
		// - 가로 : -5000 ~ 5000
		// = 세로 : -5000 ~ 5000
		// 전체를 돌리니까 메모리 초과
		// - 주어진 범위만 저장
		int lenX = x2 - x1 + 1; // x 주어진 범위
		int lenY = y2 - y1 + 1; // y 주어진 범위
		int arr[][] = new int[lenY][lenX];
		int cnt = 1; // 숫자
		int num = 0; // 오른쪽 위 / 왼쪽 아래
		int x = 0;
		int y = 0;

		// (0, 0) 값 넣기
		if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
			arr[y - y1][x - x1] = cnt;

		// 모든 값 구하기
		func: while (true) {
			// 오른쪽 & 위
			num++;
			// 오른쪽
			for (int i = 0; i < num; i++) {
				x++;
				cnt++;
				if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
					arr[y - y1][x - x1] = cnt;
				if (x < -5000 || y < -5000 || x > 5000 || y > 5000)
					break func;
			}
			// 위
			for (int i = 0; i < num; i++) {
				y--;
				cnt++;
				if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
					arr[y - y1][x - x1] = cnt;
				if (x < -5000 || y < -5000 || x > 5000 || y > 5000)
					break func;
			}

			// 왼쪽 & 아래
			num++;
			// 왼쪽
			for (int i = 0; i < num; i++) {
				x--;
				cnt++;
				if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
					arr[y - y1][x - x1] = cnt;
				if (x < -5000 || y < -5000 || x > 5000 || y > 5000)
					break func;
			}
			// 아래
			for (int i = 0; i < num; i++) {
				y++;
				cnt++;
				if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
					arr[y - y1][x - x1] = cnt;
				if (x < -5000 || y < -5000 || x > 5000 || y > 5000)
					break func;
			}
		}

		int lenMax = 0;
		for (int i = 0; i < lenY; i++) {
			for (int j = 0; j < lenX; j++) {
				String s = arr[i][j] + "";
				lenMax = Math.max(lenMax, s.length());
			}
		}

		for (int i = 0; i < lenY; i++) {
			for (int j = 0; j < lenX; j++) {
				String s = arr[i][j] + "";
				for (int k = 0; k < lenMax - s.length(); k++)
					sb.append(" ");
				sb.append(s + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}