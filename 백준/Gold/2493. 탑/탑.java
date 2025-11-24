import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> dq = new ArrayDeque<>(); // max값 저장하는 stack
		int MAX = 100_000_001;
		dq.add(new int[] { MAX, 0 });
		for (int i = 1; i <= n; i++) {
			int now = Integer.parseInt(st.nextToken());
			while (!dq.isEmpty()) {
				int prev[] = dq.removeLast();
				if (now < prev[0]) {
					sb.append(prev[1] + " ");
					dq.add(prev);
					dq.add(new int[] { now, i });
					break;
				}
			}
		}
		System.out.println(sb);
	}
}