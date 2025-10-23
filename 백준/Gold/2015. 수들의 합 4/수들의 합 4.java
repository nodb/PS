import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		long answer = 0L;
		long sum = 0L;

		Map<Long, Long> hm = new HashMap<>(); // 누적합 등장 횟수 저장
		hm.put(0L, 1L); // 공집합 누적합 0 한 번 본 것으로 초기화

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			// 이전에 sum - K 였던 누적합의 개수를 정답에 더한다.
			if (hm.containsKey(sum - k)) {
				answer += hm.get(sum - k);
			}

			// 현재 sum 등장 횟수 갱신
			if (hm.containsKey(sum)) {
				hm.put(sum, hm.get(sum) + 1L);
			} else {
				hm.put(sum, 1L);
			}
		}
		System.out.println(answer);
	}
}
