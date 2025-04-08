import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int arr[] = new int[a];
		int dp1[] = new int[a];
		int dp2[] = new int[a];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
			}
		}
		for (int i = a - 1; i >= 0; i--) {
			for (int j = a - 1; j > i; j--) {
				if (arr[i] > arr[j])
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
			}
		}

		int max = 0;
		for (int i = 0; i < a; i++) {
			max = Math.max(max, dp1[i] + dp2[i] + 1);
		}
		System.out.println(max);
	}
}