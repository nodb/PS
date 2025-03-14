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

		Arrays.fill(time, -1);

		Queue<Integer> q = new LinkedList<>();

		q.offer(n);
		time[n] = 0;

		while (!q.isEmpty()) {
			int now = q.poll(); // 현재 위치

			int[] nexts = { now - 1, now + 1, now * 2 };
			for (int next : nexts) {
				if (next < 0 || next > MAX)
					continue;
				if (time[next] == -1 || time[next] > time[now]) { // 첫 방문이거나 현재 시간보다 클 때 
					time[next] = next == now * 2 ? time[now] : time[now] + 1; // -1, +1 : 현재 시간 + 1, *2 : 현재 시간
					q.offer(next);
				}
			}
		}
		System.out.println(time[k]);
	}
}