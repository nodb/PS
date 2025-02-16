import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			cnt = cnt * 2 + 1;
		}
		sb.append(cnt + "\n");
		cal(n, 1, 3, 2);
		System.out.println(sb);
	}

	private static void cal(int num, int start, int end, int bridge) {
		if (num == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		cal(num - 1, start, bridge, end);
		sb.append(start + " " + end + "\n");
		cal(num - 1, bridge, end, start);
	}
}

// 1
// 3
// 7
// 7 + 7 + 1 = 15