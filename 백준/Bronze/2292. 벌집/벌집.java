import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(1);
			return;
		}
		N--;
		int cnt = 1;
		while (N > 0) {
			N -= cnt++ * 6;
		}
		System.out.println(cnt);
	}
}