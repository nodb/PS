import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0L;
		int min = Integer.MAX_VALUE;
		int left = 0;
		for (int right = 0; right < n; right++) {
			sum += arr[right];
			if (sum >= s) {
				while (sum - arr[left] >= s) {
					sum -= arr[left];
					left++;
				}
				min = Math.min(min, right - left);
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? 0 : min + 1);
	}
}