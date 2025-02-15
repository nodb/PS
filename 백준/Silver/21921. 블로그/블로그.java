import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int arr[] = new int[x];
		for (int i = 0; i < x; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0, cnt = 0, sum = 0;

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < x; i++) {
			q.offer(arr[i]);
			sum += arr[i];
			if (q.size() == n) {
				if (sum > max) {
					max = sum;
					cnt = 1;
				} else if (sum == max) {
					cnt++;
				}
				sum -= q.poll();
			}
		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}

	}
}
