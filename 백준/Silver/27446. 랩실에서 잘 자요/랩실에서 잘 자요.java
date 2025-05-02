import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[Integer.parseInt(st.nextToken())] = true;
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i]) { // i is true
				cnt++;
			} else { // i is false
				if (cnt == 0) {
					continue;
				} else if (cnt == 1 && i - 1 != 1) {
					arr[i - 1] = false;
				} else if (cnt == 2 && i - 2 != 1) {
					arr[i - 2] = false;
					arr[i - 1] = false;
				}
				cnt = 0;
			}
		}
		cnt = 0;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (!arr[i]) { // i is false
				cnt++;
			} else { // i is true
				if (cnt == 0) {
					continue;
				} else {
					sum += 5 + cnt * 2;
					cnt = 0;
				}
			}
		}
		if (cnt != 0) {
			sum += 5 + cnt * 2;
			cnt = 0;
		}
		System.out.println(sum);
	}
}