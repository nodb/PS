import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	static int n;
	static boolean visited[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			subset(i, 1);
			visited[i] = false;
		}
		System.out.println(min);
	}

	static void subset(int num, int cnt) {
		if (cnt == n / 2) {
			check();
			return;
		}
		for (int i = num + 1; i < n; i++) {
			visited[i] = true;
			subset(i, cnt + 1);
			visited[i] = false;
		}
	}

	static void check() {
		int A[] = new int[n / 2];
		int B[] = new int[n / 2];
		int cntA = 0;
		int cntB = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i])
				A[cntA++] = i;
			else
				B[cntB++] = i;
		}
		int sumA = 0;
		int sumB = 0;
		for (int i : A) {
			for (int j : A) {
				sumA += arr[i][j];
			}
		}
		for (int i : B) {
			for (int j : B) {
				sumB += arr[i][j];
			}
		}
		min = Math.min(min, Math.abs(sumB - sumA));
	}
}
