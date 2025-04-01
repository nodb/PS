import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		boolean check = true;

		for (int i = 0; i < n / 2; i++) {
			if (s.charAt(i) != s.charAt(n - 1 - i)) {
				check = false;
				break;
			}
		}
		System.out.println(check ? 1 : 0);
	}
}
