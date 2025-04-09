import java.io.*;
import java.util.*;

public class Main {

	static Map<Long, Long> dp = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		dp.put(0L, 1L);
		System.out.println(A(N, P, Q));
	}

	private static long A(long n, int p, int q) {
		if (dp.containsKey(n))
			return dp.get(n);

		long result = A(n / p, p, q) + A(n / q, p, q);
		dp.put(n, result);
		return result;
	}
}
