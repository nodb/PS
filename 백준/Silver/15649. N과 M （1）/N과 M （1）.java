import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1]; // 방문 여부를 추적하기 위한 배열
		int[] sum = new int[M];

		combi(0, sum);
	}

	private static void combi(int cnt, int[] sum) {
		if (cnt == M) {
			for (int i : sum) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sum[cnt] = i;
				combi(cnt + 1, sum);
				sum[cnt] = 0;
				visited[i] = false;
			}
		}
	}
}