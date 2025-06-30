import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == 'T')
					// 비트마스킹으로 각 세로를 비트마스킹으로 받기
					// T는 1, H는 0
					arr[i] |= (1 << j);
			}
		}

		int min = Integer.MAX_VALUE;

		// 모든 경우 구하기
		// 모두 뒤집기 : 가로 2^N, 세로 2^N => 4^N, N은 20 : 시간 초과
		// - 가로만 뒤집고, 세로는 T, H 개수 중 더 작은 것을 T로 채택
		for (int i = 0; i < (1 << N); i++) {
			// 각 경우의 T 개수 세기
			// - 세로 방향으로 세기
			int sum = 0;
			for (int x = 0; x < N; x++) {
				int cnt = 0;
				for (int y = 0; y < N; y++) {
					int isT = ((arr[y] >> x) & 1);
					if (((i >> y) & 1) == 1) {
						isT ^= 1;
					}
					cnt += isT;
				}
				// 세로는 개수가 더 작은 쪽 선택
				sum += Math.min(cnt, N - cnt);
				if (sum >= min)
					break;
			}
			min = Math.min(min, sum);
		}
		System.out.println(min);
	}
}
