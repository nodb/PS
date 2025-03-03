import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            sb.append(reg(k, n) + "\n");
		}

        System.out.println(sb);
    }

    static int reg(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        // 0층
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int floor = 1; floor <= k; floor++) {
            for (int room = 1; room <= n; room++) {
                dp[floor][room] = dp[floor][room - 1] + dp[floor - 1][room];
            }
        }

        return dp[k][n];
    }
}
