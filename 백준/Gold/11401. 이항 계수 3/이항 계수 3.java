import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] fac_save;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // N! 계산을 위한 배열 초기화
        fac_save = new int[N + 1];  
        fac_save[0] = 1;  // 0! = 1

        // N! 계산 (팩토리얼)
        for (int i = 1; i <= N; i++) {
            fac_save[i] = (int)((long) fac_save[i - 1] * i % MOD);
        }

        /*
         * 페르마의 소정리: nCr % p = (n! / (r!(n-r)!)) % p
         * == n! * (r!(n-r)!)^(p-2) % p
         * == n! * (r!(n-r)!)^(MOD-2) % MOD
         */

        int facN = fac_save[N];  // N!
        int facK = fac_save[K];  // K!
        int facNK = fac_save[N - K]; // (N-K)!

        // (K! * (N-K)!)^(MOD-2) 계산
        int denominator = pow((long) facK * facNK % MOD, MOD - 2);

        // 최종 결과 계산
        int result = (int)((long) facN * denominator % MOD);
        System.out.println(result);
    }

    // 분할 정복을 이용한 거듭제곱 (n^p % MOD)
    private static int pow(long n, int p) {
        if (p == 0)
        	return 1;  // n^0 = 1
        long half = pow(n, p / 2);  
        long result = (half * half) % MOD;  // 분할 정복
        if (p % 2 == 1)
        	result = (result * n) % MOD;  // p가 홀수이면 한 번 더 곱하기
		return (int) result;
	}
}
