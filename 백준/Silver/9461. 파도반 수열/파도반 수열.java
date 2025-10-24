import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			long[] arr = new long[101];

			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			for (int i = 4; i <= 100; i++) {
				arr[i] = arr[i - 3] + arr[i - 2];
			}
			sb.append(arr[n] + "\n");
		}
		System.out.println(sb);
	}
}