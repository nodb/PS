import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long cnt = 0;
		for (int i = 0; i < n - 3; i += 2) {
			cnt += arr[i + 1] - arr[i];
		}
		cnt += arr[n - 1] - arr[n - 3];
		
		int min = (int) cnt;
		for (int i = n - 4; i >= 1; i -= 2) {
			cnt -= arr[i];
			cnt += arr[i + 1];
			cnt += arr[i + 1];
			cnt -= arr[i + 2];
			min = Math.min(min, (int) cnt);
		}
		System.out.println(min);
	}
}