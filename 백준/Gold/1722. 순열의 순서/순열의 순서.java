import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());

		long[] fact = new long[n + 1];
		fact[0] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = fact[i - 1] * i;
		}

		if (p == 1) {
			long k = Long.parseLong(st.nextToken()); // 1-based
			k--; // 0-based 로 변환

			boolean[] used = new boolean[n + 1]; // 1 ~ n 사용 여부

			for (int pos = 0; pos < n; pos++) {
				long block = fact[n - 1 - pos]; // 이 자리에서 한 숫자당 차지하는 블록 크기
				int idx = (int) (k / block); // 아직 안 나온 숫자들 중 idx번째 숫자 선택
				k %= block;

				int num = 0;
				for (int x = 1; x <= n; x++) {
					if (used[x])
						continue;
					if (idx == 0) {
						num = x;
						break;
					}
					idx--;
				}

				used[num] = true;
				sb.append(num + " ");
			}
		} else if (p == 2) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			boolean[] used = new boolean[n + 1];
			long order = 1; // 1-based 결과

			for (int pos = 0; pos < n; pos++) {
				int cur = arr[pos];
				int smallerUnused = 0;

				// 아직 사용되지 않았고 cur보다 작은 수 개수 세기
				for (int x = 1; x < cur; x++) {
					if (!used[x])
						smallerUnused++;
				}
				order += smallerUnused * fact[n - 1 - pos];
				used[cur] = true;
			}
			sb.append(order);
		}
		System.out.println(sb);
	}
}
