import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[31][31];
		
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = dp[i][i] = 1;
        }
        
        for (int n = 1; n <= 30; n++) {
            for (int r = 1; r < n; r++) {
                dp[n][r] = dp[n - 1][r - 1] + dp[n - 1][r];
            }
        }
		
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(dp[n][r]).append("\n");
        }
        System.out.print(sb);
	}
}
