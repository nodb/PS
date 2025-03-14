import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
			max = sum;
		}
		for (int i = k; i < n; i++) {
			sum -= arr[i-k];
			sum += arr[i];
			if (sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}
