import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int arr[] = new int[101];
		int min = 101;
		int max = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			min = Math.min(min, start);
			max = Math.max(max, end);
			for (int time = start + 1; time <= end; time++) {
				arr[time]++;
			}
		}
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		for (int i = min; i <= max; i++) {
			if (arr[i] == 1)
				cnt1++;
			else if (arr[i] == 2)
				cnt2++;
			else if (arr[i] == 3)
				cnt3++;
		}
		System.out.println(a * cnt1 + 2 * b * cnt2 + 3 * c * cnt3);
	}
}