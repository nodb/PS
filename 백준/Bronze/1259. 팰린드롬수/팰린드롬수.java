import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String num = br.readLine();
			if (num.equals("0"))
				break;

			boolean flag = true;
			for (int i = 0; i < num.length() / 2; i++) {
				if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
					flag = false;
					break;
				}
			}
			if (flag)
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		System.out.print(sb);
	}
}
