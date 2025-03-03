import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int num = 666;

		while (true) {
			if (String.valueOf(num++).contains("666")) {
				if (++cnt == N)
					break;
			}
		}
		System.out.println(--num);
	}
}
