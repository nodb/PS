import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] arr = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] L = new int[w]; // i까지의 왼쪽 최대
		int[] R = new int[w]; // i부터의 오른쪽 최대

		L[0] = arr[0];
		for (int i = 1; i < w; i++)
			L[i] = Math.max(L[i - 1], arr[i]);

		R[w - 1] = arr[w - 1];
		for (int i = w - 2; i >= 0; i--)
			R[i] = Math.max(R[i + 1], arr[i]);

		int ans = 0;
		for (int i = 0; i < w; i++) {
			if (h > 0)
				ans += Math.min(L[i], R[i]) - arr[i];
		}
		System.out.println(ans);
	}
}
