import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long sum = 0;
		long hash = 1;
		for (int i = 0; i < N; i++) {
			sum += (s.charAt(i) - 'a' + 1) * hash;
			hash *= 31;
		}
		System.out.println(sum);
	}
}