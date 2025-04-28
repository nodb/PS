import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 0 <= N <= P
		int score = Integer.parseInt(st.nextToken()); // 0 <= newScore <= 2_000_000_000
		int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트 개수, 10 <= P <= 50

		// 둘째 줄은 N이 0보다 큰 경우에만 주어진다.
		if (N == 0) { // N이 0일 때 P >= 10이므로
			System.out.println(1);
			return;
		}

		// N > 0
		st = new StringTokenizer(br.readLine()); // 내림차순 입력
		int rank = 0;
		if (N < P) {
			rank = N + 1;
			for (int i = 1; i <= N; i++) {
				int input = Integer.parseInt(st.nextToken()); // 입력값
				if (score >= input) { // score >= 입력값 : 종료
					rank = i;
					break;
				}
			}
		} else if (N == P) {
			rank = -1;
			for (int i = 1; i <= N; i++) {
				int input = Integer.parseInt(st.nextToken()); // 입력값
				if (rank == -1) { // rank 값 저장 전
					if (score > input) { // score > 입력값 : 종료
						rank = i;
						break;
					} else if (score == input) { // score == 입력값 : 같은 점수 확인 필요
						rank = i;
						if (i == N) { // 마지막 값이라면 : -1
							rank = -1;
						}
					}
				} else { // rank 값 저장 후
					// score == input : 다음 값 확인
					if (score > input) { // score > 입력값 : 종료
						break;
					}
					if (i == N) { // 마지막 값까지 같으면
						if (i == P) { // 10개 이상이면 : -1
							rank = -1;
							break;
						} else {
							break;
						}

					}
				}
			}
		}
		System.out.println(rank);
	}
}