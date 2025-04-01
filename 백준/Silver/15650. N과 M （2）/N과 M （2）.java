import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[M];
		visited = new boolean[N];
		perm(0);

	}

	private static void perm(int cnt) {
		if (M == cnt) {
			for (int i : nums) {
				System.out.print(i + 1 + " ");	
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			for (int j = 0; j <= i; j++) {
				visited[j] = true;
			}
			nums[cnt] = i;
			perm(cnt + 1);
			nums[cnt] = 0;
			for (int j = 0; j <= i; j++) {
				visited[j] = false;
			}
		}
	}
}
