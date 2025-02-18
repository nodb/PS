import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		cnt = 0;
		def(n, r);
		System.out.println(cnt);
	}

	private static void def(int n, int r) {
		if (r == 1 || r == n) {
			cnt++;
			return;
		}
		def(n - 1, r);
		def(n - 1, r - 1);
	}
}
