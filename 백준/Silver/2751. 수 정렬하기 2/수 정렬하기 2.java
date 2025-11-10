import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (Integer i : arr) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
