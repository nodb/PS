import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Long> list = new ArrayList<>();

		// 비트마스킹 : 1~10자리(21억)까지
		for (int mask = 1; mask < (1 << 10); mask++) {
			long num = 0;
			// digit : 비트가 켜져 있는 자리
			for (int digit = 9; digit >= 0; digit--)
				// mask 해당 digit가 1이면 = AND 해서 0이 아니면
				if ((mask & (1 << digit)) != 0)
					// 해당 수 이어붙이기
					num = num * 10 + digit;
			list.add(num);
		}

		Collections.sort(list);
		System.out.println(N >= list.size() ? -1 : list.get(N));
	}
}
