import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		int n;
		String word;

		Pair(int n, String word) {
			this.n = n;
			this.word = word;
		}
	}

	static String English[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		List<Pair> list = new ArrayList<>();

		for (int i = n1; i <= n2; i++) {
			String word = convert(i);
			list.add(new Pair(i, word));
		}

		Collections.sort(list, Comparator.comparing(w -> w.word));

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).n + " ");
			if ((i + 1) % 10 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}

	// 숫자 → 영어
	private static String convert(int n) {
		if (n < 10)
			return English[n];
		int n10 = n / 10;
		int n1 = n % 10;
		return English[n10] + " " + English[n1];
	}
}
