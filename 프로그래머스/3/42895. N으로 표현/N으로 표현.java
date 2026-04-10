import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number)
            return 1;

        // dp[i] = N을 i번 사용해서 만들 수 있는 모든 수
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }

        for (int i = 1; i <= 8; i++) {
            // N, NN, NNN 같은 수 만들기
            int repeated = 0;
            for (int j = 0; j < i; j++) {
                repeated = repeated * 10 + N;
            }
            dp[i].add(repeated);

            // j개 사용한 결과와 (i-j)개 사용한 결과를 조합
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }

            // number를 만들 수 있으면 최소 사용 횟수 반환
            if (dp[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }
}