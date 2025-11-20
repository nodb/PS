import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[100001];
		arr[2] = 1;
		arr[4] = 2;
		arr[5] = 1;
		for (int i = 6; i <= n; i++) {
			if (arr[i - 2] == 0 && arr[i - 5] == 0)
				continue;
			if (arr[i - 2] == 0)
				arr[i] = arr[i - 5] + 1;
			else if (arr[i - 5] == 0)
				arr[i] = arr[i - 2] + 1;
			else
				arr[i] = Math.min(arr[i - 2] + 1, arr[i - 5] + 1);
		}
		System.out.println(arr[n] == 0 ? -1 : arr[n]);
	}
}
