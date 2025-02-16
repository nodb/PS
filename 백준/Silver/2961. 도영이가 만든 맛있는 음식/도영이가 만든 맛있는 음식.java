import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean visited[];
	static int arr[][];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[n];
		subset(0);
		System.out.println(min);
	}

	private static void subset(int cnt) {
		if (cnt == n) {
			int s = 1;
			int b = 0;
			int count = 0; // 선택한 재료 개수
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					s *= arr[i][0];
					b += arr[i][1];
					count++;
				}
			}
	        if (count > 0) {
	            min = Math.min(min, Math.abs(s - b));
	        }
	        return;
		}
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}
}