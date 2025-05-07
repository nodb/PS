import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int alph[] = new int[26];
		for (char c : br.readLine().toCharArray()) {
			alph[c - 'A']++;
		}
		next:
		for (int i = 0; i < n - 1; i++) {
			int temp[] = alph.clone();
			for (char c : br.readLine().toCharArray()) {
				temp[c - 'A']--;
			}
			boolean isOne = false;
			boolean isMinusOne = false;
			for (int j = 0; j < 26; j++) {
				if (temp[j] == 1) {
					if (!isOne) { // 1이 없다면(첫 번째 1이면)
						isOne = true;
					} else { // 이미 1이 있다면(두 번째 1이면)
						continue next;
					}
				} else if (temp[j] == -1) {
					if (!isMinusOne) { // -1이 없다면(첫 번째 -1이면)
						isMinusOne = true;
					} else { // 이미 -1이 있다면(두 번째 -1이면)
						continue next;
					}
				} else if (temp[j] != 0) {
					continue next;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
