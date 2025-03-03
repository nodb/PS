import java.io.*;
import java.util.*;

public class Main {

	static class Paper {
		int index;
		int priority;

		public Paper(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<Paper> q = new LinkedList<>();
			Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.add(new Paper(i, priority));
				pq.add(priority);
			}

			int printOrder = 0;
			out:
			while (!q.isEmpty()) {
				Paper current = q.poll();

				if (current.priority == pq.peek()) { // 가장 높은 중요도와 일치하면 인쇄
					pq.poll();
					printOrder++;

					if (current.index == M) { // 찾고 있던 문서라면 출력
						sb.append(printOrder).append("\n");
						break out;
					}
				} else {
					q.add(current); // 다시 큐 삽입
				}
			}
		}
		System.out.print(sb);
	}
}
