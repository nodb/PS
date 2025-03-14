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
		int[] ways = new int[MAX + 1]; // 가능한 경로 수

		Arrays.fill(time, -1);

		Queue<Integer> q = new LinkedList<>();

		q.offer(n);
		time[n] = 0;
		ways[n] = 1;

		while (!q.isEmpty()) {
			int now = q.poll(); // 현재 위치
			int[] nexts = { now - 1, now + 1, now * 2 };
			for (int next : nexts) {
				if (next < 0 || next > MAX)
					continue;
				if (time[next] == -1) { // 첫 방문
					time[next] = time[now] + 1; // 시간 : 현재 시간 + 1
					ways[next] = ways[now]; // 가능한 경로 수 : 현재 경로 수
					q.offer(next);
				} else if (time[next] == time[now] + 1) // 이전 방문, 최소 시간
					ways[next] += ways[now]; // 기존 경로 수 += 현재 경로 수
			}
		}
		System.out.println(time[k] + "\n" + ways[k]);
	}
}
