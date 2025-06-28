import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);

		// 최소 시간 구하기 → 결정 문제 : T 시간 안에 M명 이상 심사
		// 이진 탐색 - 별도 조건있으므로 파라메트릭 서치
		// - 최소 소요 시간 : 1
		// - 최대 소요 시간 : 가장 느림 심사대 * M
		long answer = 0;
		long left = 1;
		long right = (long) list.get(N - 1) * M;
		while (left <= right) {
			long mid = (left + right) / 2;
			// mid 시간 동안 심사할 수 있는 사람 수
			// - 각 심사관 심사 사람 수 : mid / 각 심사시간
			long total = 0;
			for (int time : list) {
				total += mid / time;
				// total이 M을 넘으면 셀 필요가 없음
				// - 최악의 경우 오버플로우 발생
				if (total >= M)
					break;
			}

			// 심사할 수 있는 사람수가 M보다 크거나 같다면
			// - 시간 줄이기
			if (total >= M) {
				right = mid - 1;
				answer = mid;
			}

			// 심사할 수 있는 사람수가 M보다 작다면
			// - 시간 늘리기
			else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
//list    | 2 3 3 4 6 8 9 | 원하는 합 : 10
//time: 9 | 4 3 3 2 1 1 1 | 합 : 15
//time: 8 | 4 2 2 2 1 1 0 | 합 : 12   크거나 같을 때 시간 줄이기
//time: 7 | 3 2 2 1 1 0 0 | 합 : 9    작을 때 시간 늘리기