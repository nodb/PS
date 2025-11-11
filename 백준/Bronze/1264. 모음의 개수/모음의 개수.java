import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.equals("#"))
				break;
			char c[] = s.toCharArray();
			int cnt = 0;
			for (char cc : c) {
				if (cc == 'a' || cc == 'e' || cc == 'i' || cc == 'o' || cc == 'u') {
					cnt++;
				}
				if (cc == 'A' || cc == 'E' || cc == 'I' || cc == 'O' || cc == 'U') {
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
