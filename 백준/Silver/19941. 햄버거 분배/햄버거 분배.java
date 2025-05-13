import java.io.*;
import java.util.*;

public class Main {
	static int arr[];
	static int n, k, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		int cnt = 0;
		for (char c : br.readLine().toCharArray()) {
			if (c == 'H')
				arr[cnt] = 1;
			cnt++;
		}

		cnt = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) { // 사람일 때
				for (int j = i - k; j <= i + k; j++) { // 범위 안
					if (j < 0 || j >= n) // 0보다 작으면 넘어가고
						continue;
					if (arr[j] == 1) { // 햄버거일 때
						arr[i] = 2;
						arr[j] = 3;
						cnt++;
						break;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}