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
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		System.out.println(A(N, P, Q, X, Y));
	}

	private static long A(long n, int p, int q, int x, int y) {
		if (n <= 0)
			return 1;
		if (dp.containsKey(n))
			return dp.get(n);

		long result = A((n / p) - x, p, q, x, y) + A((n / q) - y, p, q, x, y);
		dp.put(n, result);
		return result;
	}
}
