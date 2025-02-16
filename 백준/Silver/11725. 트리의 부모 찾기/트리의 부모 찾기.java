import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list[];
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			list[first].add(second);
			list[second].add(first);
		}
		fun(1);
		for (int i = 2; i <= n; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void fun(int num) {
		for (int i : list[num]) {
			if (arr[i] == 0) {
				arr[i] = num;
				fun(i);
			}
		}
	}
}
