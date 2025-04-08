import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[1_000_001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = -1_000_000_001;
		int max = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			int b = Arrays.binarySearch(arr, num);
			if (b < 0) {
				b = (b * -1) - 1;
				arr[b] = num;
			}
			max = Math.max(max, b);
		}
		System.out.println(max);
	}
}