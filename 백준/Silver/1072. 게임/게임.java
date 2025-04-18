import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		int z = (int) (100 * y / x);

		if (z >= 99) {
			System.out.println(-1);
			return;
		}

		long left = 1, right = 1_000_000_000L, result = -1;
		while (left <= right) {
			long mid = (left + right) / 2;
			int newZ = (int) (100 * (y + mid) / (x + mid));
			if (newZ > z) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(result);
	}
}
