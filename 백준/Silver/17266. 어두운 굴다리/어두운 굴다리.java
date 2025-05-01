import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = 0;
		int min = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			min = (int) Math.max(min, Math.ceil((now - prev) / 2.0));
			prev = now;
		}
		min = Math.max(min, N - prev);
		System.out.println(min);
	}
}