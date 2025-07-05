import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			if (s.matches("(100+1+|01)+"))
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}
