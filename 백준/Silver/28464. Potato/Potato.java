import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int max = 0;
		int min = 0;
		for (int i = 0; i < n / 2; i++) {
			min += arr[i];
		}
		for (int i = n / 2; i < n; i++) {
			max += arr[i];
		}
		System.out.println(min + " " + max);
	}
}
