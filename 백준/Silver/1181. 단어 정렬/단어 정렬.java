import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Set<String> ts = new TreeSet<>((a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length();
			return a.compareTo(b);
		});

		for (int i = 0; i < n; i++) {
			ts.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		for (String word : ts) {
			sb.append(word).append('\n');
		}
		System.out.print(sb);
	}
}
