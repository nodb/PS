import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);

		int cnt = 0;
		int first = 0, last = n - 1;

		while (first < last) {
			if (arr[first] + arr[last] == x) {
				cnt++;
				first++;
				last--;
			} else if (arr[first] + arr[last] < x) {
				first++;
			} else if (arr[first] + arr[last] > x) {
				last--;
			}

		}

		System.out.println(cnt);
	}
}
