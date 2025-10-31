import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		a:
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			Map<Long, Long> m = new HashMap<>();
			for (int i = 0; i < t; i++) {
				long num = Long.parseLong(st.nextToken());
				m.put(num, m.getOrDefault(num, 0L) + 1);
			}
			for (Long key : m.keySet()) {
				if (m.get(key) > t / 2) {
					sb.append(key + "\n");
					continue a;
				}
			}
			sb.append("SYJKGW\n");
		}
		System.out.println(sb);
	}
}
