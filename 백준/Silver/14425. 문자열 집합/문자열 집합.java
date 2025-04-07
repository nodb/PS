import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;

		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			hs.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (hs.contains(s)) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
