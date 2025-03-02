import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int K = Integer.parseInt(br.readLine());
			Queue<Long> q = new PriorityQueue<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				q.add(Long.parseLong(st.nextToken()));
			}

			long result = 0;
			while (q.size() > 1) {
				long first = q.poll();
				long second = q.poll();
				result += first + second;
				q.add(first + second);
			}
			sb.append(result + "\n");
		}

		System.out.print(sb);
	}
}
