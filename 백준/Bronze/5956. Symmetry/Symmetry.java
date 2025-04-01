import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		System.out.println(func(n, m));
	}

	static long func(long n, long m) {
		if (n % 2 == 0 || m % 2 == 0) {
			return 0;
		}
		return 1 + 4 * func(n / 2, m / 2);
	}
}