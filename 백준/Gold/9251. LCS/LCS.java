import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		int Alen = A.length();
		int Blen = B.length();

		// dp[j] = A[0..i-1], B[0..j-1]의 LCS 길이 (j는 1..Blen)
		int[] dp = new int[Blen + 1];

		for (int i = 1; i <= Alen; i++) {
			int prev = 0; // 이전 행의 dp[j-1] (대각선 값)
			for (int j = 1; j <= Blen; j++) {
				int temp = dp[j]; // 갱신 전 현재 칸 값(다음 칸의 대각선이 됨)
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[j] = prev + 1; // 대각선 + 1
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]); // 위 or 왼
				}
				prev = temp; // 다음 j에서 쓸 대각선 값 갱신
			}
		}

		System.out.println(dp[Blen]);
	}
}

/*
 * |   |   | C | A | P | C | A | K |
 * |   | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
 * | A | 0 | 0 | 1 | 1 | 1 | 1 | 1 |
 * | C | 0 | 1 | 1 | 1 | 2 | 2 | 2 |
 * | A | 0 | 1 | 2 | 2 | 2 | 3 | 3 |
 * | Y | 0 | 1 | 2 | 2 | 2 | 3 | 3 |
 * | K | 0 | 1 | 2 | 2 | 2 | 3 | 4 |
 * | P | 0 | 1 | 2 | 3 | 3 | 3 | 4 |
 */