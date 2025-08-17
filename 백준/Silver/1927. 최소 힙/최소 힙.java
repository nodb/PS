import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 우선순위 큐 사용
		// - 가장 작은 값을 출력을 위해!
		// - 큐(Queue) : 먼저 들어오는 데이터가 먼저 나가는 자료구조, FIFO(First In First Out)
		// - 우선순위 큐(Priority Queue) : 우선순위가 높은 데이터가 먼저 나가는 자료구조
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// N번 입력 받기
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.size() == 0)
					sb.append(0).append('\n');
				else
					sb.append(pq.remove()).append('\n');
			} else {
				pq.add(x);
			}
		}
		System.out.println(sb);
	}
}