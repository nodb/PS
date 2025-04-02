import java.io.*;
import java.util.*;

public class Main {
	static int cnt;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.equals("end"))
				return;
			boolean accept = false;

			String alph = "aeiou";
			for (int i = 0; i < 5; i++) {
				if (s.contains(alph.charAt(i) + "")) {
					accept = true;
					break;
				}
			}

			if (accept) {
				boolean prevAlph = false;
				if (alph.contains(s.charAt(0) + ""))
					prevAlph = true;
				int cnt = 0;
				for (int i = 1; i < s.length(); i++) {
					boolean nowAlph = alph.contains(s.charAt(i) + "");
					if (prevAlph == nowAlph) { // 자모음 연속
						cnt++;
						if (cnt == 2) { // 연속 세 개
							accept = false;
							break;
						}
						if (s.charAt(i) == s.charAt(i - 1)) { // 연속 두 개 같은 문자
							if (s.charAt(i) == 'e' || s.charAt(i) == 'o') // 예외
								continue;
							else {
								accept = false;
								break;
							}
						}
					} else {
						cnt = 0;
						prevAlph = nowAlph;
					}
				}
			}
			System.out.println("<" + s + "> is " + (accept ? "" : "not ") + "acceptable.");
		}
	}
}
