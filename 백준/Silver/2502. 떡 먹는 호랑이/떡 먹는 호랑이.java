import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = 1, B = 1;
		for (int i = 3; i < D; i++) {
			int temp = B;
			B = A + B;
			A = temp;
		}
		for (int i = 1; i < K; i++) {
			if ((K - (i * A)) % B == 0) {
				sb.append(i).append("\n").append((K - (i * A)) / B);
				break;
			}
		}
		System.out.println(sb);
	}
}