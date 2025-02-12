import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
	static int N;
	static BigDecimal arr[];
	static BigDecimal two = new BigDecimal("2");
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 홀수면 3번째로 이동
		
		arr = new BigDecimal[101];
		for (int i = 1; i <= 100; i++) {
			arr[i] = new BigDecimal("0");
		}
		
		arr[1] = BigDecimal.ONE;
		
		for (int i = 2; i <= 100; i++) {
			arr[i] = arr[i-1].multiply(two).add(BigDecimal.ONE);
		}
		
		System.out.println(arr[N]);
		if (N <= 20) {
			h(N, 1, 3, 2); // 1 -> 3
			System.out.println(sb);
		}
	}

	private static void h(int n, int start, int end, int bridge) {
		if (n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		h(n-1, start, bridge, end);
		sb.append(start + " " + end + "\n");
		h(n-1, bridge, end, start);
	}
}
