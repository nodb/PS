import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()); // 인벤토리
		int arr[][] = new int[N][M];

		int minH = Integer.MAX_VALUE; // 땅 최소 높이
		int maxH = 0; // 땅 최대 높이

		// 땅의 높이 입력
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				int n = Integer.parseInt(st.nextToken());
				arr[y][x] = n;

				// 땅 최소 높이보다 작은 값이면 -> 최소 높이 갱신
				if (n < minH)
					minH = n;

				// 땅 최대 높이보다 높은 값이면 -> 최대 높이 갱신
				if (n > maxH)
					maxH = n;
			}
		}

		// 정답 높이 : 땅 최소 높이 ~ 최대 높이 중 하나
		// 왜냐하면
		// (땅 최소 높이 > 정답 높이) 가정하면 : 정답 높이일 때가 최소 높이일 때 보다 시간이 오래 걸려서 불가능
		// (땅 최대 높이 < 정답 높이) 가정하면 : 정답 높이일 때가 최대 높이일 때 보다 시간이 오래 걸려서 불가능

		// 따라서 모든 경우의 수를 다 보는 경우를 생각해보자
		// 최악인 경우를 가정
		// - 땅 최소 높이 : 0
		// - 땅 최대 높이 : 256
		// 즉 0 ~ 256의 높이가 가능
		// N, M의 최대값이 500이므로
		// 500x500 배열의 최대 가능한 경우는 : 500x500x256 = 64,000,000 = 6.4x10^7 <- B의 최대 값

		// 자바는 1초에 약 1억 연산 횟수가 가능
		// -> 따라서 최악의 경우인 64,000,000에서도 1초 안에 모든 경우를 확인 가능
		// -> 따라서 모든 경우를 확인하는 '그리디 방식'을 사용

		int time[] = new int[257]; // 높이에 따른 시간
		// 최소 높이 ~ 최대 높이일 때
		for (int h = minH; h <= maxH; h++) { // h : 목표 높이
			int tempB = B;
			// 각 배열의 높이와 목표 높이의 차로 인한 시간을 저장
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (arr[y][x] < h) { // 목표 높이보다 작으면
						time[h] += h - arr[y][x]; // 블록 놓기(1초)
						tempB -= h - arr[y][x]; // 인벤토리 블록 제거
					} else if (arr[y][x] > h) { // 목표 높이보다 높으면
						time[h] += (arr[y][x] - h) * 2; // 블록 제거(2초)
						tempB += arr[y][x] - h; // 인벤토리 블록 추가
					}
				}
			}
			// 인벤토리의 블록이 0보다 작다면
			// - 해당 높이 사용 X
			// - 이후 높이 사용 X
			if (tempB < 0) {
				maxH = h - 1; // 높이 값을 minH ~ maxH 까지 확인할 때 현재 h 값 전까지만 확인하도록 maxH 갱신
				break; // 더이상 높이 값 갱신 X
			}
		}

		int minTime = Integer.MAX_VALUE; // 최소 시간
		int minHigh = minH; // 최소 높이
		for (int h = minH; h <= maxH; h++) {
			// h의 시간이 최소 시간보다 작거나 같다면 갱신
			// 답이 여러 개 있다면 땅의 높이가 가장 높은 것 -> 같은 경우 포함
			if (time[h] <= minTime) {
				minHigh = h; // 높이 갱신
				minTime = time[h];
			}
		}
		
		System.out.println(minTime + " " + minHigh);
	}
}