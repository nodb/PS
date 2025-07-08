import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N]; // 섞기 전 카드 순서
		for (int i = 0; i < N; i++)
			arr[i] = i;

		int P[] = new int[N]; // 최종 목표
		int S[] = new int[N]; // 섞는 규칙
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			S[i] = Integer.parseInt(st.nextToken());

		HashSet<Integer> P0 = new HashSet<>();
		HashSet<Integer> P1 = new HashSet<>();
		HashSet<Integer> P2 = new HashSet<>();
		for (int i = 0; i < N; i++) {
			if (P[i] == 0)
				P0.add(i);
			else if (P[i] == 1)
				P1.add(i);
			else
				P2.add(i);
		}

		int cnt = 0;
		while (true) {
			// 섞기 전
			// - 최종 목표와 일치 여부 확인
			// - 0인 경우가 있기에 섞기 전 먼저 확인
			boolean isSame = true; // 최종 목표와 일치 여부
			for (int i = 0; i < N; i++) {
				if (i % 3 == 0) {
					if (!P0.contains(arr[i])) {
						isSame = false;
						break;
					}
				} else if (i % 3 == 1) {
					if (!P1.contains(arr[i])) {
						isSame = false;
						break;
					}
				} else {
					if (!P2.contains(arr[i])) {
						isSame = false;
						break;
					}
				}
			}
			if (isSame) { // 최종 목표와 모두 같다면
				System.out.println(cnt);
				break;
			}

			// 섞기
			int copy[] = new int[N];
			for (int i = 0; i < N; i++)
				copy[S[i]] = arr[i];
			arr = copy.clone();
			cnt++;

			// 섞은 후
			// - 첫 카드 순서와 같다면 -1 출력
			boolean isCircle = true;
			for (int i = 0; i < N; i++) {
				if (arr[i] != i) {
					isCircle = false;
					break;
				}
			}
			if (isCircle) {
				System.out.println(-1);
				break;
			}
		}
	}
}