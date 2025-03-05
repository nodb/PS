import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[] list = new int[T];
		int max = 0;
		for (int i = 0; i < T; i++) {
			list[i] = Integer.parseInt(br.readLine());
			if (list[i] > max) {
				max = list[i];
			}
		}

		long[] arr = new long[max + 1];

		if (max >= 1)
			arr[1] = 1;
		if (max >= 2)
			arr[2] = 1;
		if (max >= 3)
			arr[3] = 1;

		for (int i = 4; i <= max; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}

		for (int n : list) {
			sb.append(arr[n]).append("\n");
		}

		System.out.print(sb);
	}
}
