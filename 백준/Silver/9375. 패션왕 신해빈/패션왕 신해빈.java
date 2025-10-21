import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> m = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s = st.nextToken();
				int cnt = 0;
				if (m.containsKey(s)) {
					cnt = m.get(s);
				}
				m.put(s, cnt + 1);
			}
			int result = 1; // 출력 값
			for (int num : m.values()) {
				result *= num + 1;
			}
			sb.append(result - 1).append("\n");
		}
		System.out.println(sb);
	}
}