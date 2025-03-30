import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 6; i >= 0; i--) {
			if (x >= 1 << i) {
				cnt++;
				x -= 1 << i;
			}
		}
		System.out.println(cnt);
	}
}