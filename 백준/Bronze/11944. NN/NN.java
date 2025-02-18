import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String n = st.nextToken();
		int m = Integer.parseInt(st.nextToken());
		int len = n.length();
		if (Integer.parseInt(n) * len < m) {
			for (int i = 0; i < Integer.parseInt(n); i++) {
				sb.append(n);
			}
		} else {
			for (int i = 0; i < m / len; i++) {
				sb.append(n);
			}
			for (int i = 0; i < m % len; i++) {
				sb.append(n.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
