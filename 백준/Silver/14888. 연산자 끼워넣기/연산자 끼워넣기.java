import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int arr[];
	static int save[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int op[] = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) // +, -, ×, ÷
			op[i] = Integer.parseInt(st.nextToken());
		save = new int[N - 1];
		func(0, op);
		System.out.println(max + "\n" + min);
	}

	private static void func(int cnt, int op[]) {
		if (cnt == N - 1) {
			int sum = arr[0];
			for (int i = 0; i < N - 1; i++) {
				if (save[i] == 0)
					sum += arr[i + 1];
				else if (save[i] == 1)
					sum -= arr[i + 1];
				else if (save[i] == 2)
					sum *= arr[i + 1];
				else if (save[i] == 3)
					sum /= arr[i + 1];
			}
			if (sum > max)
				max = sum;
			if (sum < min)
				min = sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i]--;
				save[cnt] = i;
				func(cnt + 1, op);
				op[i]++;
			}
		}
	}
}