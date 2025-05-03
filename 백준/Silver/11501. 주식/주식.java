import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			int N = Integer.parseInt(br.readLine());

			long sum = 0;
			int max = 0;
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > max) {
					max = arr[i];
				} else {
					sum += max - arr[i];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
