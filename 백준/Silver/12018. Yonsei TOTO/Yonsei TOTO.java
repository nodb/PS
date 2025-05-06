import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 1 <= 과목수 <= 100
		int m = Integer.parseInt(st.nextToken()); // 1 <= 마일리지 <= 100
		PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // 과목별 최소 필요 마일리지
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 1 <= 신청인원 <= 100
			int l = Integer.parseInt(st.nextToken()); // 1 <= 수강인원 <= 100

			st = new StringTokenizer(br.readLine());
			if (p < l) { // 신청인원 < 수강인원
				min.offer(1);
				continue;
			}
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int j = 0; j < p; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			for (int j = 0; j < p - l; j++) {
				pq.poll();
			}
			min.offer(pq.poll());
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += min.poll();
			if (sum < m) {
				continue;
			} else if (sum == m) {
				System.out.println(i + 1);
				return;
			} else if (sum > m) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(n);
	}
}
