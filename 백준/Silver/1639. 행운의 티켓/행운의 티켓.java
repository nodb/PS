import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int left = 0;
			int right = 0;
			for (int j = 0; j <= Math.min(i, arr.length - 2 - i); j++) {
				left += arr[i - j] - '0';
				right += arr[i + 1 + j] - '0';
				if (left == right)
					max = Math.max(max, (j + 1) * 2);
			}
		}
		System.out.println(max);
	}
}