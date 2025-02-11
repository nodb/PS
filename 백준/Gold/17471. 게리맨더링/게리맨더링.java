import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int arr[];
	static List<Integer> list[];
	static boolean visited[];
	static List<Integer> A;
	static List<Integer> B;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= cnt; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		visited = new boolean[n + 1];
		subset(1);
		
		System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
	}

	private static void subset(int cnt) {
        if (cnt == n + 1) {
            A = new ArrayList<>();
            B = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (visited[i]) A.add(i);
                else B.add(i);
            }

            if (A.isEmpty() || B.isEmpty()) return;

            if (bfs(A) && bfs(B)) {
                int sumA = 0, sumB = 0;
                for (int num : A) sumA += arr[num];
                for (int num : B) sumB += arr[num];

                minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
            }
            return;
        }
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}

    private static boolean bfs(List<Integer> start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n + 1];

        queue.add(start.get(0));
        check[start.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list[now]) {
                if (start.contains(next) && !check[next]) {
                    check[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count == start.size();
    }
}
