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
			int len = c.length;
			int cnt = 0;
			for (char cc : c) {
				if (cc == '-')
					cnt += 0 * Math.pow(8, --len);
				else if (cc == '\\')
					cnt += 1 * Math.pow(8, --len);
				else if (cc == '(')
					cnt += 2 * Math.pow(8, --len);
				else if (cc == '@')
					cnt += 3 * Math.pow(8, --len);
				else if (cc == '?')
					cnt += 4 * Math.pow(8, --len);
				else if (cc == '>')
					cnt += 5 * Math.pow(8, --len);
				else if (cc == '&')
					cnt += 6 * Math.pow(8, --len);
				else if (cc == '%')
					cnt += 7 * Math.pow(8, --len);
				else if (cc == '/')
					cnt -= Math.pow(8, --len);
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
