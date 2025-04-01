import java.io.*;

public class Main {
	static int cnt;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			s = br.readLine();
			cnt = 0;
			System.out.println(check(0, s.length() - 1) + " " + cnt);
		}
	}

	public static int check(int left, int right) {
		cnt++;
		if (left >= right)
			return 1;
		if (s.charAt(left) != s.charAt(right))
			return 0;
		return check(left + 1, right - 1);
	}
}
