import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		int arrCopy[] = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt = end;
			for (int j = 1; j <= N; j++) {
				if (j < start || j > end)
					arrCopy[j] = arr[j];
				else
					arrCopy[j] = arr[cnt--];

			}
			for (int j = 1; j <= N; j++) {
				arr[j] = arrCopy[j];
			}
		}
		for (int i = 1; i <= N; i++)
			System.out.print(arr[i] + " ");
	}
}
