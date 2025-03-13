import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long max5 = N / 5;
		long cnt5 = 0;
		long cnt3 = 0;
		for (long tempcnt5 = max5; tempcnt5 >= 0; tempcnt5--) {
			long rest = N - 5 * tempcnt5;
			if (rest % 3 == 0) {
				cnt5 = tempcnt5;
				cnt3 = rest / 3;
				break;
			}
		}
		System.out.println((cnt5 + cnt3 != 0 ? cnt5 + cnt3 : -1));
	}
}