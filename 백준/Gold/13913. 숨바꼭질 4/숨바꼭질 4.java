import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] time = new int[MAX + 1]; // 걸린 시간
		int[] ways = new int[MAX + 1]; // 부모 노드

		Arrays.fill(time, -1);

		Queue<Integer> q = new LinkedList<>();

		q.offer(n);
		time[n] = 0;
		ways[n] = -1;

		while (!q.isEmpty()) {
			int now = q.poll(); // 현재 위치
			int[] nexts = { now - 1, now + 1, now * 2 };
			for (int next : nexts) {
				if (next < 0 || next > MAX)
					continue;
				if (time[next] == -1) { // 첫 방문
					time[next] = time[now] + 1; // 시간 : 현재 시간 + 1
					ways[next] = now;
					q.offer(next);
				}
			}
		}
		System.out.println(time[k]);

		int cnt = time[k];
		ArrayList<Integer> list = new ArrayList<>();

		list.add(k);
		for (int i = 0; i < cnt; i++) {
			list.add(ways[k]);
			k = ways[k];
		}

		Collections.reverse(list);
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
}
