import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int maxJ = -arr[0];
		int maxJI = Integer.MIN_VALUE; // A[j] - A[i] 최대
		int maxJIL = Integer.MIN_VALUE; // A[j] - A[i] - A[k] 최대
		int maxJILK = Integer.MIN_VALUE; // A[j] - A[i] + A[l] - A[k] 최대

		for (int i = 1; i < N; i++) {
			if (i >= 3)
				maxJILK = Math.max(maxJILK, maxJIL + arr[i]);
			if (i >= 2)
				maxJIL = Math.max(maxJIL, maxJI - arr[i]);
			maxJI = Math.max(maxJI, maxJ + arr[i]);
			maxJ = Math.max(maxJ, -arr[i]);
		}
		System.out.println(maxJILK);
	}
}
