import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N < 10) {
			System.out.println(N);
			return;
		}

		Queue<Long> q = new LinkedList<>();
		for (long i = 1; i <= 9; i++)
			q.add(i);

		int cnt = 9;

		while (!q.isEmpty()) {
			long num = q.poll();
			int last = (int) (num % 10);

			// 앞보다 작은 수까지만
			for (int d = 0; d < last; d++) {
				long next = num * 10 + d;
				q.add(next);
				cnt++;

				if (cnt == N) {
					System.out.println(next);
					return;
				}
			}
		}

		System.out.println(-1);
	}
}
