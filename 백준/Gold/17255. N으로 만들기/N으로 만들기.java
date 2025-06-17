import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine().trim();
		int N = S.length();

		if (N == 1) {
			System.out.println(1);
			return;
		}

		Set<List<String>> hs = new HashSet<>();

		int len = N - 1;
		int maxbit = 1 << len;

		for (int bit = 0; bit < maxbit; bit++) {
			char[] array = new char[len];
			for (int i = 0; i < len; i++) {
				if (((bit >> i) & 1) == 1)
					array[i] = 'L';
				else
					array[i] = 'R';
			}

			for (int i = 0; i < N; i++) {
				int l = i, r = i;
				List<String> list = new ArrayList<>();
				list.add(S.substring(l, r + 1));

				boolean check = false;
				for (char c : array) {
					if (c == 'L') {
						if (l == 0) {
							check = true;
							break;
						}
						l--;
					} else {
						if (r == N - 1) {
							check = true;
							break;
						}
						r++;
					}
					list.add(S.substring(l, r + 1));
				}

				if (!check && l == 0 && r == N - 1) {
					hs.add(list);
				}
			}
		}

		System.out.println(hs.size());
	}
}
