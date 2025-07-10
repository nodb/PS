import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];
		int min = 300;
		int max = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] < min)
					min = arr[i][j];
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}

		int minTime = Integer.MAX_VALUE;
		int maxHeight = 0;
		for (int height = min; height <= max; height++) {
			int time = 0;
			int restB = B;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (height < arr[y][x]) { // 기준 높이 < 현재 높이 : 더 높음
						restB += arr[y][x] - height; // 남은 블럭 → 현재 높이 - 기준 높이 만큼 더하기
						time += 2 * (arr[y][x] - height);
					} else if (height > arr[y][x]) { // 기준 높이 > 현재 높이 : 더 낮음
						restB -= height - arr[y][x]; // 남은 블럭 → 기준 높이 - 현재 높이 만큼 빼기
						time += height - arr[y][x];
					}
				}
			}
			// 땅 고르게 걸리는 최소 시간 & 땅 최대 높이
			// 남은 블럭 >= 0, 최소 시간
			if (restB >= 0 && time <= minTime) {
				minTime = time;
				maxHeight = height;
			}
		}
		System.out.println(minTime + " " + maxHeight);
	}

}