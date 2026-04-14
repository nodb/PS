import java.io.*;
import java.util.*;

public class Main {
	static class Rule {
		int a; // 시작 상자
		int b; // 끝 상자
		int c; // 간격

		Rule(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static int n, k, d;
	static Rule rules[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 상자 개수
		k = Integer.parseInt(st.nextToken()); // 규칙 개수
		d = Integer.parseInt(st.nextToken()); // 도토리 개수

		rules = new Rule[k];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			rules[i] = new Rule(a, b, c);
		}

		int left = 1;
		int right = n;
		int answer = n;

		// 이분 탐색:
		// "mid번 상자까지 도토리가 d개 이상 들어갔는가?"
		// 를 기준으로 가장 작은 상자 번호를 찾음
		while (left <= right) {
			int mid = (left + right) / 2;

			if (count(mid) >= d) {
				// mid번 상자까지 이미 d개 이상 들어갔으면
				// 정답은 mid 이하에 있을 수 있음
				answer = mid;
				right = mid - 1;
			} else {
				// mid번 상자까지 d개 미만이면
				// 정답은 더 오른쪽에 있음
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}

	// 1번 상자부터 x번 상자까지 들어간 도토리 총 개수 계산
	static long count(int x) {
		long total = 0;

		for (Rule rule : rules) {
			// x가 시작 상자보다 작으면 이 규칙으로는 아직 아무 도토리도 못 넣음
			if (x < rule.a)
				continue;

			// 이 규칙이 실제로 영향을 주는 마지막 상자
			int end = Math.min(x, rule.b);

			// rule.a, rule.a + c, rule.a + 2c, ... <= end
			// 등차수열의 항 개수 공식
			total += (end - rule.a) / rule.c + 1;
		}

		return total;
	}
}