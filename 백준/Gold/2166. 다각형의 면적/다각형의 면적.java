import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        // 다각형의 첫 번째 점을 마지막에도 추가
        x[n] = x[0];
        y[n] = y[0];

        // 신발끈 공식
        double sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += (double) x[i] * y[i + 1];
            sum2 += (double) y[i] * x[i + 1];
        }

        double area = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f\n", area);
    }
}
