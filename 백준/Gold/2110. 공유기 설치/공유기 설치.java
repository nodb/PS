import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max)
				max = arr[i];
		}
		Arrays.sort(arr);
		int min = 1;
		int result = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			int cnt = 1;
			int select = arr[0];
			for (int i = 1; i < N; i++) {
				if (select + mid <= arr[i] ) {
					select = arr[i];
					cnt++;
				}
			}
			if (cnt >= C) {
				result = mid;
				min = mid + 1;
			} else
				max = mid - 1;
		}
		System.out.println(result);
	}
}
