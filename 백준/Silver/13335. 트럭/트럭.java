import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 트럭 수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int l = Integer.parseInt(st.nextToken()); // 다리 최대 하중

		int[] truck = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}

		int[] bridge = new int[w];
		int head = 0, tail = 0;
		int sum = 0;
		int time = 0;
		int idx = 0;

		while (idx < n || sum > 0) {
			time++;

			// 다리의 head 위치에서 트럭이 빠져나감
			sum -= bridge[head];
			bridge[head] = 0;
			head = (head + 1) % w;

			// 새 값 추가?
			if (idx < n && sum + truck[idx] <= l) {	// 최대 하중보다 작거나 같다면
				bridge[tail] = truck[idx];
				sum += truck[idx];
				idx++;
			} else {
				// 못 들어오면 0
				bridge[tail] = 0;
			}
			tail = (tail + 1) % w;
		}
		System.out.println(time);
	}
}