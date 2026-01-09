import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Integer> pq[];
	static int cnt = 0;
	static int sNum, pNum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue[7];
		for (int i = 0; i < 7; i++) {
			pq[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sNum = Integer.parseInt(st.nextToken());
			pNum = Integer.parseInt(st.nextToken());
			check();
		}
		System.out.println(cnt);
	}

	static void check() {
		if (pq[sNum].isEmpty()) {
			pq[sNum].add(pNum);
			cnt++;
		}
		int prev = pq[sNum].peek();
		// 들어있는 값이랑 같다면
		if (pNum == prev) {
			return;
		}
		// 들어있는 값보다 크다면
		else if (pNum > prev) {
			pq[sNum].add(pNum);
			cnt++;
			return;
		}
		// 들어있는 값보다 작다면
		else {
			pq[sNum].remove();
			cnt++;
			check();
		}
	}
}
