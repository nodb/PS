import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, max = 0;
	static int arr[], d[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		d = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && d[i] <= d[j]) {
					d[i] = d[j] + 1;
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			if (d[i] > max) {
				max = d[i];
			}
		}
		System.out.println(max);
	}
}
