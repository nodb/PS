import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int cnt = 1;
		int sum = 0;
		while (true) {
			sum += cnt++;
			if (sum >= x)
				break;
		}
		if (cnt % 2 == 0)
			System.out.println((sum - x + 1) + "/" + (cnt - sum + x - 1));
		else
			System.out.println((cnt - sum + x - 1) + "/" + (sum - x + 1));
	}
}