import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static long a, b, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
        System.out.println(pow(a, b, c));
    }

    // 분할 정복을 이용한 거듭제곱 (빠른 거듭제곱)
    static long pow(long base, long exp, long mod) {
        if (exp == 0) return 1; // a^0 = 1
        long half = pow(base, exp / 2, mod);
        half = (half * half) % mod;
        return (exp % 2 == 0) ? half : (half * base) % mod;
    }
}
