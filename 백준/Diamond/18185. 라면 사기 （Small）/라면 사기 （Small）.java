import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		long cost = 0;

		// 비용 절감 -> 3개 구매 최대화
		// 3개로 맞추기
		for (int i = 0; i < N; i++) {
			// i, i+1
			// i+1 > i+2인 경우 i, i+1 맞추기
			if (i + 2 < N && A[i + 1] > A[i + 2]) {
				int num = Math.min(A[i], A[i + 1] - A[i + 2]);
				cost += 5 * num;
				A[i] -= num;
				A[i + 1] -= num;
			}

			// i, i+1, i+2
			if (i + 2 < N) {
				int num = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
				cost += 7 * num;
				A[i] -= num;
				A[i + 1] -= num;
				A[i + 2] -= num;
			}

			// i, i+1
			if (i + 1 < N) {
				int num = Math.min(A[i], A[i + 1]);
				cost += 5 * num;
				A[i] -= num;
				A[i + 1] -= num;
			}

			// i 한 곳
			cost += 3 * A[i];
//			System.out.println(Arrays.toString(A));
		}

		System.out.println(cost);
	}
}
