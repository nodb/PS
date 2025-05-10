import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int kit[];
	static boolean visited[];
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 운동 키트 개수
		k = Integer.parseInt(st.nextToken()); // 감소 중량
		
		kit = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[n];
		perm(0, 0);
		
		System.out.println(cnt);
	}

	private static void perm(int depth, int rest) {
		if (depth == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			if (rest + kit[i] < k) {
				continue;
			}
			visited[i] = true;
			perm(depth + 1, rest + kit[i] - k);
			visited[i] = false;
		}
	}
}
